package br.com.mariojp.project;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;

	public void start(int port) {
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				new Thread(new ClientHandler(socket)).start();
			}
		} catch (IOException e) {
			System.out.println("Exit Server");
		}

	}

	public void stop() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.start(4444);
		server.stop();
	}
}
