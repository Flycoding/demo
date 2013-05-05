package com.flyingh.demo4;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Demo2 {

	private XMLReader xmlReader;
	private static final String PATH = "src/test/java/com/flyingh/demo4/books.xml";

	@Before
	public void before() throws SAXException, ParserConfigurationException {
		xmlReader = SAXParserFactory.newInstance().newSAXParser()
				.getXMLReader();
	}

	@Test
	public void test2() {
		xmlReader.setContentHandler(new DefaultHandler() {
			private String currentQName;
			private int number;
			private int requiredNumber = 2;

			@Override
			public void startElement(String uri, String localName,
					String qName, Attributes attributes) throws SAXException {
				currentQName = qName;
				if ("name".equals(currentQName)) {
					++number;
				}
			}

			@Override
			public void characters(char[] ch, int start, int length)
					throws SAXException {
				if (number == requiredNumber && "name".equals(currentQName)) {
					System.out.println(new String(ch, start, length));
				}
			}
		});
	}

	@Test
	public void test() {
		xmlReader.setContentHandler(new DefaultHandler() {

			@Override
			public void startElement(String uri, String localName,
					String qName, Attributes atts) throws SAXException {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < atts.getLength(); i++) {
					sb.append(" ").append(atts.getQName(i)).append("=\"")
							.append(atts.getValue(i)).append("\"");
				}
				startln(qName + sb);
			}

			private void startln(String qName) {
				System.out.println("<" + qName + ">");
			}

			@Override
			public void endElement(String uri, String localName, String qName)
					throws SAXException {
				endln(qName);
			}

			private void endln(String qName) {
				System.out.println("</" + qName + ">");
			}

			@Override
			public void characters(char[] ch, int start, int length)
					throws SAXException {
				System.out.println(new String(ch, start, length));
			}
		});
	}

	@After
	public void after() throws IOException, SAXException {
		xmlReader.parse(PATH);
	}

}
