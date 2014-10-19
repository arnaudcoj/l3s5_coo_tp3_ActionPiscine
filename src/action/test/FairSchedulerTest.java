package action.test;

import static org.junit.Assert.*;

import org.junit.Test;

import action.*;

public class FairSchedulerTest {
	private class OneStepAction extends ForeseeableAction {
		public OneStepAction() throws Exception {
			super(1);
		}
	}


	@Test
	public void testReallyDoStep() {
	}

	@Test
	public void testIsReady() {
		Scheduler s = new FairScheduler();
		Action a1 = null;
		Action a2 = null;
		Action a3 = null;
		try {
			a1 = new OneStepAction();
			a2 = new OneStepAction();
			a3 = new OneStepAction();
		} catch (Exception e) {
			fail("ne devrait pas fail maintenant");
		}
		s.addAction(a1);
		s.addAction(a2);
		s.addAction(a3);
		assertTrue(s.isReady());
		try {
			s.doStep();
		} catch (Exception e) {
			fail("l'action ne devrait pas etre finie");
		}
		assertFalse(s.isReady());
}
	
//	@Test
//	public void testFairSchedulerListOfAction() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFairScheduler() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIsFinished() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testScheduler() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSchedulerListOfAction() {
//		fail("Not yet implemented");
//	}

}
