package action;

public class ForeseeableAction extends Action {

	private final int totalTime;
	private int remainTime;
	
	public ForeseeableAction(int tot) throws Exception {
		if (tot <= 0)
			throw new IllegalArgumentException();
		this.totalTime = tot;
		this.remainTime = tot;		
	}

	public boolean isReady() {
		return totalTime == remainTime;
	}
	
	public boolean isFinished() {
		return remainTime == 0;
	}
	
	protected void reallyDoStep() throws ActionFinishedException {
		if(this.isFinished())
			throw new ActionFinishedException();
		this.remainTime--;
	}
}
