package lms;

import java.util.Calendar;


/**
 * Represents a resource in a library collection.
 * @author Jill Seaman
 *
 */
public abstract class Resource  {

	public final static int CHECKED_OUT = 0;
	public final static int ON_THE_SHELF = 1;
	
	private int resourceID;           // library's id number
    private String title;             // product title
    private Calendar dueDate;         // date the Resource is due back
    private int status;               // status (availability) of the item
                                      // currently only checked out or on the shelf
 

	/**
	 * Constructs Product from parameters.
	 * @param resourceID
	 * @param title
	 */
	public Resource(int resourceID, String title) {
		this.resourceID = resourceID;
		this.title = title;
		this.status = ON_THE_SHELF;   //by default it is available
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

    public int getResourceID() {
        return resourceID;
    }

	public Calendar getDueDate() {
		return (Calendar)dueDate.clone();
	}

	/**
	 * A  setter for the dueDate attribute, saves a copy of the argument.
	 * @param dueDate
	 */
	public void setDueDate(Calendar dueDate) {
		this.dueDate = (Calendar)dueDate.clone();
	}
	
	/**
	 * Calculates the dueDate by adding the appropriate amount of time to 
     * a copy of the startDate.
	 * @param startDate is the date the resource is checked out.
	 * @param member the member checking out the book
     * @return the date the resource should be due.
	 */
	abstract public Calendar calculateNewDueDate(Calendar startDate, Member member);
	
    /**
     * Calculates the fine assuming the book is returned on the given date.
     * Library members are fined $0.25 per day that the books are overdue 
     * to a maximum of $5.00 per overdue item.
     * @param date is the date that the book was returned.
     * @return the calculated fine.
     */
	public double calculateFine(Calendar date) {
		if (dueDate==null)
			return 0;
		// .25 per day, up to 5.00 max
		if (date.after(dueDate)) {
			long span = date.getTimeInMillis() - dueDate.getTimeInMillis();
		    long numberOfMSInADay = 1000*60*60*24;
		    long days = span / numberOfMSInADay;
			double fine = days * 0.25;
			return (Math.min(fine,5.00));
		}
		return 0;
	}
}