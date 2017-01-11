package com.nicolaslagos.festivities.repository;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;

import org.junit.Test;

import com.nicolaslagos.festivities.domain.Festivity;

/**
 * 
 * @author Nicolas Lagos Ruiz
 *
 */
public class FestivityDaoTests {

private FestivityDao festivityDao;
		
	/**
	 * Tests getAllFestivities DAO
	 * @throws Exception 
	 * @throws NotFoundException 
	 */
	@Test
	public void testGetFestivityList () throws NotFoundException, Exception {
		List<Festivity> festivityList = FestivityDao.getInstance().getFestivity();
		assertNotNull(festivityList);
	}
	
	/**
	 * Tests add Festivity
	 */
	@Test
	public void testAddFestivity () {
		Festivity testFestivity = new Festivity();
		Date start = Calendar.getInstance().getTime();
		Date end = Calendar.getInstance().getTime();
		testFestivity.setId(0);
		testFestivity.setName("aFestivityName");
		testFestivity.setPlace("aFestivityPlace");
		testFestivity.setStartDate(start);
		testFestivity.setEndDate(end);
		FestivityDao.getInstance().addFestivity(testFestivity);
		Map<String, Object> testValues = new HashMap<String, Object>();
		testValues.put("name", "aFestivityName");
		testValues.put("place", "aFestivityName");
		//TODO there's an error where Java's dates and MySql's dates are not the same, there is a second difference
		//testValues.put("start", start);
		//testValues.put("end", end);
	    assertEquals(testFestivity.getId(), FestivityDao.getInstance().getFestivity(testValues).get(0).getId());
	}
	
	/**
	 * Tests update Festivity
	 */
	@Test 
	public void testUpdateFestivity(){
		Festivity testFestivity = new Festivity();
		Date start = Calendar.getInstance().getTime();
		Date end = Calendar.getInstance().getTime();
		testFestivity.setId(0);
		testFestivity.setName("aFestivityName");
		testFestivity.setPlace("aFestivityPlace");
		testFestivity.setStartDate(start);
		testFestivity.setEndDate(end);
		FestivityDao.getInstance().addFestivity(testFestivity);
		testFestivity.setName("aFestivityNameUpdate");
		FestivityDao.getInstance().updateFestivity(testFestivity.getId(), testFestivity);
		Map<String, Object> queryFields = new HashMap<String, Object>();
		queryFields.put("name", "aFestivityNameUpdate");
		assertEquals(testFestivity.getId(),FestivityDao.getInstance().getFestivity(queryFields).get(0).getId());
	}
	
}
