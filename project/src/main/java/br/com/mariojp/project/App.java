package br.com.mariojp.project;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String args[]) {

		Server server = new Server();
		//Start Server
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Start Server");
				server.start(4444);
			}
		}).start();

		
		//Start Client
		Client client1 = new Client();
		client1.startConnection("localhost", 4444);
		
		Client client2 = new Client();
		client2.startConnection("localhost", 4444);
		
		
		System.out.println(client1.sendMessage("Hello"));
		System.out.println(client1.sendMessage("Java is Very Good!!!"));
		
		System.out.println(client2.sendMessage("Hello"));
		System.out.println(client2.sendMessage("Java is Very Good!!!"));
		
		
		System.out.println(client1.sendMessage("Amazing!!!"));
		System.out.println(client1.sendMessage("."));
		client1.stopConnection();

		System.out.println(client2.sendMessage("Amazing!!!"));
		System.out.println(client2.sendMessage("."));
		client2.stopConnection();
		
		
		
		server.stop();

		
	}
	
}
