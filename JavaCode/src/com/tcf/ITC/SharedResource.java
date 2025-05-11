package com.tcf.ITC;

public class SharedResource {
	
	 private boolean isProduced = false;

	    synchronized void produce() {
	        while (isProduced) {
	            try {
	                wait(); // wait until consumed
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	        System.out.println("Produced data");
	        isProduced = true;
	        notify(); // notify consumer
	    }

	    synchronized void consume() {
	        while (!isProduced) {
	            try {
	                wait(); // wait until produced
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	        System.out.println("Consumed data");
	        isProduced = false;
	        notify(); // notify producer
	    }
}