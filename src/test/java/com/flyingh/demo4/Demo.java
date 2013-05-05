package com.flyingh.demo4;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Demo {
	private Document document;
	private static final String PATH = "src/test/java/com/flyingh/demo4/books.xml";

	@Before
	public void before() throws SAXException, IOException,
			ParserConfigurationException {
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(getClass().getResourceAsStream("books.xml"));
	}

	@Test
	public void test() {
		System.out.println(document.getDocumentElement().getNodeName());
		System.out.println(document.getDocumentElement().getTagName());
	}

	@Test
	public void update() throws TransformerConfigurationException,
			TransformerException, TransformerFactoryConfigurationError {
		document.getElementsByTagName("name").item(1).setTextContent("Android");
		save();
	}

	@Test
	public void delete2() throws TransformerConfigurationException,
			TransformerException, TransformerFactoryConfigurationError {
		Element item = (Element) document.getElementsByTagName("name").item(0);
		item.removeAttribute("a");
		save();
	}

	@Test
	public void delete() throws TransformerConfigurationException,
			TransformerException, TransformerFactoryConfigurationError {
		Node deletingNode = document.getElementsByTagName("info").item(0);
		deletingNode.getParentNode().removeChild(deletingNode);
		save();
	}

	@Test
	public void add3() throws TransformerConfigurationException,
			TransformerException, TransformerFactoryConfigurationError {
		Element nameElement = (Element) document.getElementsByTagName("name")
				.item(0);
		nameElement.setAttribute("a", "b");
		save();
	}

	@Test
	public void add2() throws TransformerConfigurationException,
			TransformerException, TransformerFactoryConfigurationError {
		Node refNode = document.getElementsByTagName("price").item(0);
		Element newNode = document.createElement("info");
		newNode.setTextContent("hello world");
		refNode.getParentNode().insertBefore(newNode, refNode);
		save();
	}

	@Test
	public void add() throws TransformerConfigurationException,
			TransformerException, TransformerFactoryConfigurationError {
		Element priceElement = document.createElement("price");
		priceElement.setTextContent("88.88");
		document.getElementsByTagName("book").item(0).appendChild(priceElement);
		save();
	}

	private void save() throws TransformerException,
			TransformerConfigurationException,
			TransformerFactoryConfigurationError {
		TransformerFactory.newInstance().newTransformer()
				.transform(new DOMSource(document), new StreamResult(PATH));
	}

	@Test
	public void read3() {
		Element item = (Element) document.getElementsByTagName("book").item(0);
		System.out.println(item.getAttributeNode("id").getTextContent());
		System.out.println(item.getAttribute("id"));
	}

	@Test
	public void read2() {
		list(document.getDocumentElement());
	}

	private void list(Node node) {
		if (node instanceof Element) {
			System.out.println(node.getNodeName());
		}
		NodeList childNodes = node.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			list(childNodes.item(i));
		}
	}

	@Test
	public void read() {
		NodeList list = document.getElementsByTagName("book");
		Element bookElement = (Element) list.item(1);
		Element nameElement = (Element) bookElement
				.getElementsByTagName("name").item(0);
		System.out.println(nameElement.getTextContent());
	}

	@After
	public void after() {
		document = null;
	}
}
