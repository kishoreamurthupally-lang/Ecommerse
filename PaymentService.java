package services;

import java.util.Random;

public class PaymentService {

    

	public boolean processPayment() {
		 Random r = new Random();
	        return r.nextBoolean(); 
	}
}