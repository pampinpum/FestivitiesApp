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
		assertNull(festivity.getFestname());
		festivity.setFestname(testFestname);
		assertEquals(testFestname, festivity.getFestname());
	}
	
	/**
	 * tests place setter and getter
	 */
	@Test
	public void testSetAndGetFestPlace(){
		String testFestplace = "aFestPlace";
		assertNull(festivity.getFestplace());
		festivity.setFestplace(testFestplace);
		assertEquals(testFestplace, festivity.getFestplace());
	}
	
	/**
	 * tests startdate setter and getter
	 */
	@Test
	public void testSetAndGetFestStartDate(){
		Timestamp testFeststartdate = new Timestamp(Calendar.getInstance().getTimeInMillis());
		assertNull(festivity.getFeststartdate());
		festivity.setFeststartdate(testFeststartdate);
		assertEquals(testFeststartdate, festivity.getFeststartdate());
	}
	
	/**
	 * tests enddate setter and getter
	 */
	@Test
	public void testSetAndGetFestEndDate(){
		Timestamp testFestenddate = new Timestamp(Calendar.getInstance().getTimeInMillis());
		assertNull(festivity.getFestenddate());
		festivity.setFeststartdate(testFestenddate);
		assertEquals(testFestenddate, festivity.getFeststartdate());
	}



}
