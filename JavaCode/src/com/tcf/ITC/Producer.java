package com.tcf.ITC;

public class Producer extends Thread {
	
	private final SharedResource resource;

    Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.produce();
        }
    }

}