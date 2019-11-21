package bai3;

public class PutMessage extends Thread{
	QueueMessage queueMessage;
	
	
	public PutMessage(QueueMessage queueMessage) {
		this.queueMessage = queueMessage;
	}


	public void run() {
		while(true) {
			try {
				synchronized (this) {			
					int i = 0;
					while(i < 10) {
						queueMessage.getQueue().add("message"+" "+i);
						System.out.println("put "+" "+i);
						i++;
						if(i == 10) i = 0;
						Thread.sleep(1000);
					}
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
