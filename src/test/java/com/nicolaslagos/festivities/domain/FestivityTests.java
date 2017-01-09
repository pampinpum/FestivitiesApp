package com.nicolaslagos.festivities.domain;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class FestivityTests {
	
	private Festivity festivity;
	
	@Before
	public void setUp() throws Exception {
		festivity = new Festivity();
	}
	
	@Test
	public void testSetAndGetId(){
		int testId = 0;
		assertEquals(testId, festivity.getId());
		festivity.setId(testId);
		assertEquals(testId, festivity.getId());
	}
	
	@Test
	public void testSetAndGetFestName(){
		String testFestname = "aFestName";
		assertNull(festivity.getFestname());
		festivity.setFestname(testFestname);
		assertEquals(testFestname, festivity.getFestname());
	}
	
	@Test
	public void testSetAndGetFestPlace(){
		String testFestplace = "aFestPlace";
		assertNull(festivity.getFestplace());
		festivity.setFestplace(testFestplace);
		assertEquals(testFestplace, festivity.getFestplace());
	}
	
	@Test
	public void testSetAndGetFestStartDate(){
		Timestamp testFeststartdate = new Timestamp(Calendar.getInstance().getTimeInMillis());
		assertNull(festivity.getFeststartdate());
		festivity.setFeststartdate(testFeststartdate);
		assertEquals(testFeststartdate, festivity.getFeststartdate());
	}
	
	@Test
	public void testSetAndGetFestEndDate(){
		Timestamp testFestenddate = new Timestamp(Calendar.getInstance().getTimeInMillis());
		assertNull(festivity.getFestenddate());
		festivity.setFeststartdate(testFestenddate);
		assertEquals(testFestenddate, festivity.getFeststartdate());
	}



}
