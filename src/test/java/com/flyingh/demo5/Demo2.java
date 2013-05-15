package com.flyingh.demo5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class Demo2 {
	@Test
	public void test() throws IOException {
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = serverSocket.accept();
		InputStream is = getClass().getClassLoader().getResourceAsStream(
				"demo.xml");
		OutputStream os = socket.getOutputStream();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = is.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
		os.close();
		is.close();
		socket.close();
		serverSocket.close();
	}
}
