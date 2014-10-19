package action;

import java.util.ArrayList;
import java.util.List;

public abstract class Scheduler extends Action {
	
	//ATTRIBUTS
	protected List<Action> actions;
	
	//CONSTRUCTORS
	/**
	 * Create a new Scheduler with an empty list of Action
	 */
	public Scheduler(){
		super();
		this.actions = new ArrayList<Action>();
	}
	
	/**
	 * Create a new Scheduler with a list of Actions given as a parameter
	 * @param actions, the List of action you want to schedule
	 */
	public Scheduler(List<Action> actions){
		super();
		this.actions = actions;
	}
	
	//METHODS
	
	/**
	 * add an action to this Scheduler
	 * @param a , the action you want to add
	 */
	public abstract void addAction(Action a );
	
	/**
	 * the assertion that every action of this scheduler is ready
	 * @return true if every action of this scheduler is ready
	 * @return false if no
	 */
	@Override
	public boolean isReady() {
		boolean resultat = true;
		for(Action action : this.actions){
			resultat = resultat && action.isReady();
		}
		return resultat;
	}

	/**
	 * the assertion that every action of this scheduler is finished
	 * @return true if every action of this scheduler is finished 
	 * @return false if no
	 */
	@Override
	public boolean isFinished() {
		boolean resultat = true;
		for(Action action : this.actions){
			resultat = resultat && action.isFinished();
		}
		return resultat;
	}

	@Override
	protected abstract void reallyDoStep() throws ActionFinishedException;
	}
