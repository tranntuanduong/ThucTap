package bai3;

public class Main {
	public static void main(String[] args) {
		
		QueueMessage queueMessage = new QueueMessage();	
		
		PutMessage putMessage = new PutMessage(queueMessage);
		putMessage.start();
		
		ReadMessage readMessage = new ReadMessage(queueMessage);
		readMessage.start();
			
	}
}
