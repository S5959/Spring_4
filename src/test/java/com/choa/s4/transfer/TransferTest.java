package com.choa.s4.transfer;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.card.Card;

public class TransferTest extends MyTestCase {

	@Autowired
	private Bus bus;	
	
	@Autowired
	private Subway subway;
	
	@Autowired
	private Taxi taxi;
	
	//@Autowired
	private Card card;
	
	@Test
	public void test() {
		
		bus.takeBus(1250, "t-money");		//핵짐로직
		taxi.getTexi();
		subway.takeSubway();
	}

}
