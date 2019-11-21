package bai3;

public class ReadMessage extends Thread {
	QueueMessage queueMessage;
	public ReadMessage(QueueMessage queueMessage) {
		this.queueMessage = queueMessage;
	}
		
	public void run() {	
		while(true) {
			try {
				synchronized (this) {
					if(!queueMessage.getQueue().isEmpty()) {
						String out = queueMessage.getQueue().poll();
						System.out.println("out: "+out);
					}
					Thread.sleep(10);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
