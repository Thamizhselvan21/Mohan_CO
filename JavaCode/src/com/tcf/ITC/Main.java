
package com.tcf.ITC;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedResource resource = new SharedResource();

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();
	}

}
