package com.nicolaslagos.festivities.domain;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Nicolas Lagos
 *
 */
public class FestivityTests {
	
	private Festivity festivity;
	
	@Before
	public void setUp() throws Exception {
		festivity = new Festivity();
	}
	
	/**
	 * tests id setter and getter
	 */
	@Test
	public void testSetAndGetId(){
		int testId = 0;
		assertEquals(testId, festivity.getId());
		festivity.setId(testId);
		assertEquals(testId, festivity.getId());
	}
	
	/**
	 * tests name setter and getter
	 */
	@Test
	public void testSetAndGetFestName(){
		String testFestname = "aFestName";
		assertNull(festivity.getName());
		festivity.setName(testFestname);
		assertEquals(testFestname, festivity.getName());
	}
	
	/**
	 * tests place setter and getter
	 */
	@Test
	public void testSetAndGetFestPlace(){
		String testFestplace = "aFestPlace";
		assertNull(festivity.getPlace());
		festivity.setPlace(testFestplace);
		assertEquals(testFestplace, festivity.getPlace());
	}
	
	/**
	 * tests startdate setter and getter
	 */
	@Test
	public void testSetAndGetFestStartDate(){
		Timestamp testFeststartdate = new Timestamp(Calendar.getInstance().getTimeInMillis());
		assertNull(festivity.getStartDate());
		festivity.setStartDate(testFeststartdate);
		assertEquals(testFeststartdate, festivity.getStartDate());
	}
	
	/**
	 * tests enddate setter and getter
	 */
	@Test
	public void testSetAndGetFestEndDate(){
		Timestamp testFestenddate = new Timestamp(Calendar.getInstance().getTimeInMillis());
		assertNull(festivity.getEndDate());
		festivity.setStartDate(testFestenddate);
		assertEquals(testFestenddate, festivity.getStartDate());
	}



}
