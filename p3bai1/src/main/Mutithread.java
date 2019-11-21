package main;

public class Mutithread extends Thread{
	Incement incement;
	
	Mutithread(Incement incement) {
		this.incement = incement;
	}
	
	public void run() {
		incement.incement();
	}
	
}
