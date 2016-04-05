import java.security.SecureRandom;

/**
 * Print task, from examples on slides
 * SI Session Fall 2015
 */
public class PrintTask implements Runnable{			// implement runnable for run() method, and so methods that require a Runnable object can use our object.

	private static final SecureRandom generator = new SecureRandom();		// more secure than Random
	private final int sleepTime;											// store the generator's randomly generated number for how long to sleep for 
	private String taskName;

	public PrintTask(String taskName){
		this.taskName = taskName;
		sleepTime = generator.nextInt(100);									// this will give us a number between 0 and 100
	}

	public void run(){														// we need run because we're implementing interface Runnable
		// try sleeping the task for the amount of time, print
		try {
			// print out our name and how long we'll sleep for
			System.out.println(taskName + " is going to sleep for " + sleepTime);
			Thread.sleep(sleepTime);										// sleep the current thread by our special set amount of time
		} 
		// catch InterruptedException
		catch (InterruptedException e){
			// print stack trace
			e.printStackTrace();
			// reinterrupt current thread
			Thread.currentThread().interrupt();					// Thread.currentThread gets us the currently running thread
		}
		// print that it's done
		System.out.println(taskName + " is done.");
		//Thread.currentThread().suspend();
	}

}

