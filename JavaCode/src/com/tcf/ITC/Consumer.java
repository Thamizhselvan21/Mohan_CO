
package com.tcf.ITC;

public class Consumer extends Thread {
	
	 private final SharedResource resource;

	    Consumer(SharedResource resource) {
	        this.resource = resource;
	    }

	    public void run() {
	        for (int i = 0; i < 5; i++) {
	            resource.consume();
	        }
	    }
}
