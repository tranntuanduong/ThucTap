package main;

public class Incement {
	int i = 1;
	public synchronized void incement () {
		System.out.println(i);
		i++;
	}
}
