package main;

public class Main {
	public static void main(String[] args) {
		Incement incement = new Incement();
		for(int i = 0; i < 10; i++) {
			Mutithread thread = new Mutithread(incement);
			thread.start();
		}
	}
}
