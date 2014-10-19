package action;

public abstract class Action {

	public abstract boolean isReady();
	
	public abstract boolean isFinished();
	
	public boolean isInProgress() {
		return !this.isReady() && !this.isFinished();
	}
	
	public void doStep() throws ActionFinishedException {
		if (this.isFinished())
			throw new ActionFinishedException();
		this.reallyDoStep();
	}
	
	protected abstract void reallyDoStep() throws ActionFinishedException;
}
