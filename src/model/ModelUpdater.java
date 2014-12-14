package model;


/**
 * The ModelUpdater is designed to be ran in a separate thread
 * from the rest of the application. It handles the timing of
 * the automated updates that update the model with new
 * information from yahoo.
 * 
 * @author Tom Maxwell
 *
 */
class ModelUpdater implements Runnable{
	
	TrackerImp tracker;
	
	/**
	 * The constructor for the ModelUpdater.
	 * 
	 * @effects initialises this
	 * @modifies this
	 * 
	 * @param model The model we are to handle the updating
	 * for
	 */
	ModelUpdater(Tracker model){
		
		if(model instanceof TrackerImp){
		
			this.tracker = (TrackerImp) model;
		}
		
		//TODO - deal with case
	}
	
	/**
	 * The run method called upon on the thread starting.
	 * This handles the timing of the updates
	 * 
	 * @effects waits for model.refreshRate, then calls
	 * model.update
	 */
	public void run(){
		
		while(true){
		
			try {
				Thread.sleep(tracker.getRefreshRate());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tracker.updateTracker();
			tracker.modelChanged();
		}
	}
}
