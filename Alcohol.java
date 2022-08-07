/**
 * 
 * @author Sowmya Datla
 *
 */
public class Alcohol extends Beverage {
	private boolean weekend;
	private final double WEEKEND_FEE = 0.6;
	
	/**
	 * Parametrized constructor
	 * 
	 * @param namem
	 * @param size
	 * @param weekn
	 */
	public Alcohol(String namem, SIZE size, boolean weekn) {
		super(namem, TYPE.ALCOHOL, size);
		weekend = weekn;
	}
	
	/**
	 * An Overridden toString method: String representation of a alcohol drink including the name, 
	 * size, whether or not beverage is offered in the weekend and the price.
	 */
	@Override
	public String toString() {
		String theString = getBevName() + ", " + getSize();
		
		if(weekend == true) {
			theString += " Weekend";
		}
		
		theString += ", $" + calcPrice();
		
		return theString;
	}

	/**
	 * An Overridden equals method: checks equality based on the Beverage class equals method and 
	 * additional instance variables for this class.
	 * 
	 * @param a
	 * @return
	 */
	public boolean equals(Alcohol a) {
		if(weekend == a.isWeekend() && super.equals(a)) {
			return true;
		} else {
			return false;
		}
	}
	
	// Getters and Setters
	public boolean isWeekend() {
		return weekend;
	}

	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}

	public double getWEEKEND_FEE() {
		return WEEKEND_FEE;
	}
	
	// End Getters and Setters
	
	
	/**
	 * An Overridden calcPrice method
	 * 
	 * @return
	 */
	@Override
	public double calcPrice() {
		double p = super.getBasePrice();
		
		if(super.getSize() == SIZE.MEDIUM) {
			p += super.getSizePrice();
		} else if(super.getSize() == SIZE.LARGE) {
			p += 2 * super.getSizePrice();
		}
		
		if(weekend == true) {
			p += WEEKEND_FEE;
		}
		
		return p;
	}
	
	
}
