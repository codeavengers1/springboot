package com.demo.java8;

public class Main1 {

	public static void main(String[] args) throws Exception {
		Runnable worker1=new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 5; i++) {
						System.out.println(i);
						Thread.sleep(3000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			
		};
		Thread t1 = new Thread(()-> {
			
					for (int i = 0; i < 5; i++) {
						System.out.println(i);
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
			
		});

		t1.start();

		t1.join();

	}

	
}
class Worker implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}