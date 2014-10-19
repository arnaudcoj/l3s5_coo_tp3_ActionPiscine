package action;

import java.util.List;

public class SequentialScheduler extends Scheduler {

	//ATTRIBUTS
	
	protected int actionInProgress;
	protected int length;
	
	//CONSTRUCTORS
	public SequentialScheduler(){
		super();
		this.actionInProgress = 0;
		this.length = 0;
	}
	
	public SequentialScheduler(List<Action> actions) {
		super(actions);
		this.actionInProgress = 0;
		this.length = actions.size();
	}

	//METHODS
	
	@Override
	protected void reallyDoStep() throws ActionFinishedException {
		try{
			actions.get(actionInProgress).doStep();
		}catch(ActionFinishedException e){
			actionInProgress ++;
			this.reallyDoStep();
		}
	}
	
	@Override
	public void addAction(Action a){
		actions.add(a);
		this.length ++;
	}

}
