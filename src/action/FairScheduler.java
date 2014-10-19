package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FairScheduler extends Scheduler {

	// ATTRIBUTS
	protected Iterator<Action> action;

	// CONSTRUCTOR
	public FairScheduler(List<Action> actions) {
		super(actions);
		this.action = actions.iterator();
	}

	public FairScheduler() {
		this.actions = new ArrayList<Action>();
		this.action = actions.iterator();
	}

	// METHODS

	/**
	 * add an action to this Scheduler
	 * 
	 * @param a
	 *            the action you want to add
	 */
	public void addAction(Action a) {
		actions.add(a);
	}

	@Override
	protected void reallyDoStep() throws ActionFinishedException {
		if(this.action.hasNext())
			this.action.next().doStep();
	}

}
