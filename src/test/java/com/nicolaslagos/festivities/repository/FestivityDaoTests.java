package com.nicolaslagos.festivities.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nicolaslagos.festivities.domain.Festivity;

/**
 * 
 * @author Nicolas Lagos Ruiz
 *
 */
public class FestivityDaoTests {

private FestivityDao festivityDao;
	
	@Before
	public void setUp() throws Exception {
		festivityDao = new FestivityDao();
	}
	
	/**
	 * Tests getAllFestivities DAO
	 */
	@Test
	public void testGetFestivityList () {
		List<Festivity> festivityList = festivityDao.getFestivities();
		assertNotNull(festivityList);
	}

}
