import javax.swing.text.DefaultStyledDocument.AttributeUndoableEdit;

/**
 * 
 * @author Sowmya Datla
 *
 */
public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	private final double SHOT_COST = 0.5;
	private final double SYRUP_COST = 0.5;
	
	/**
	 * A parametrized constructor for Coffee
	 * 
	 * @param name
	 * @param size
	 * @param shot
	 * @param syrup
	 */
	public Coffee(String name, SIZE size, boolean shot, boolean syrup) {
		super(name, TYPE.COFFEE, size);
		extraShot = shot;
		extraSyrup = syrup;
	}
	
	/**
	 * An Overridden toString method: String representation of Coffee beverage, including the name, size, whether it contains extra shot, 
	 * extra syrup, and the price of the coffee
	 */
	@Override
	public String toString() {
		String theString = getBevName() + ", " + getSize();
		
		if(extraShot == true) {
			theString += " Extra shot";
		}
		
		if(extraSyrup == true) {
			theString += " Extra syrup";
		}
		
		theString += ", $" + calcPrice();
		
		return theString;
	}
	

	/**
	 * An Overridden calcPrice method.
	 */
	@Override
	public double calcPrice() {
		double p;
		
		p = super.getBasePrice();
		
		if(super.getSize() == SIZE.MEDIUM) {
			p += super.getSizePrice();
		}
		
		if(super.getSize() == SIZE.LARGE) {
			p += 2 * super.getSizePrice();
		}
		
		
		if(extraShot == true) {
			p += SHOT_COST;
		}
		
		if(extraSyrup == true) {
			p += SYRUP_COST;
		}
		
		return p;
	}
	
	/**
	 * An Overridden equals method: checks equality based on the Beverage class equals method
	 * and additional instance variables for this class.
	 * 
	 * @param c
	 * @return
	 */
	public boolean equals(Coffee c) {
		if(extraSyrup == c.getExtraSyrup() && extraShot == c.getExtraShot() && super.equals(c)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns if there is an extra shot or not
	 * 
	 * @return - the boolean value in extraShot
	 */
	public boolean getExtraShot() {
		return extraShot;
	}

	/**
	 * Set the boolean value of extraShot (If there is an extra shot or not)
	 * 
	 * @param extraShot
	 */
	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	/**
	 * Returns if there is extra syrup or not
	 * 
	 * @return - the boolean value in extraSyrup
	 */
	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	/**
	 * Set the boolean value of extraSyrup (If there is extraSyrup or not)
	 * 
	 * @param extraSyrup
	 */
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}

	/**
	 * Gets the SHOT_COST
	 * 
	 * @return value of SHOT_COST
	 */
	public double getSHOT_COST() {
		return SHOT_COST;
	}

	/**
	 * gets the SYRUP_COST
	 * 
	 * @return value of SYRUP_COST
	 */
	public double getSYRUP_COST() {
		return SYRUP_COST;
	}
	
	
}
