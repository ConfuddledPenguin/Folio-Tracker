package tests.Model;


import static org.junit.Assert.*;

import org.junit.*;

import model.*;

public class TrackerTest {


	public Tracker tracker;
	
	@Before
	public void setUp() {
		
		tracker = new TrackerImp();
	}
	
	@Test
	public void testCreatePortfolio() {
	
		Portfolio portfolio = tracker.createPortfolio("Test");
		
		assertEquals("Name should equal what it was told to", "Test", portfolio.getName());
	}
	
	@Test
	public void testLoadPortfolio() {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void deletePortfolio() {
		// TODO Auto-generated method stub

	}
}
