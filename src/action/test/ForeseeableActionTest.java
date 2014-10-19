package action.test;

import static org.junit.Assert.*;
import org.junit.Test;
import action.Action;
import action.ActionFinishedException;
import action.ForeseeableAction;

public class ForeseeableActionTest {

	@Test
	public void exactlyTwoSteps() throws Exception {
		Action action = new ForeseeableAction(2);
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		action.doStep();
		assertFalse(action.isReady());
		assertTrue(action.isInProgress());
		assertFalse(action.isFinished());
		action.doStep();
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}

	@Test
	public void throwsActionFinishedExceptionWhenFinished() throws Exception {
		Action action = new ForeseeableAction(1);
		action.doStep();
		try {
			action.doStep();
		} catch (ActionFinishedException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testForeseeableAction() throws Exception {
		try {
			new ForeseeableAction(-1);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

}
