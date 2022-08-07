import javafx.css.SizeUnits;

public class Smoothie extends Beverage {
	private int numOfFruits;
	private boolean addProtein;
	private final double FRUIT_COST = 0.5;
	private final double PROTEIN_COST = 1.5;
	
	/**
	 * Parametrized constructor
	 * 
	 * @param name
	 * @param size
	 * @param fruits
	 * @param pro
	 */
	public Smoothie(String name, SIZE size, int fruits, boolean pro) {
		super(name, TYPE.SMOOTHIE, size);
		numOfFruits = fruits;
		addProtein = pro;
	}
	
	/**
	 * An Overridden toString method: String representation of a Smoothie drink including the name, size, whether or not protein is added, number of fruits
	 * and the price. 
	 */
	@Override
	public String toString() {
		String theString = getBevName() + ", " + getSize() + " " + numOfFruits + " Fruits";
		
		if(addProtein ==  true) {
			theString += " Protein poweder";
		}
		
		theString += ", $" + calcPrice();
		
		return theString;
	}

	/**
	 * An Overridden equals method: checks equality based on the beverage class equals method and additional instance variabls for this class.
	 * 
	 * @param s
	 * @return
	 */
	public boolean equals(Smoothie s) {
		if(super.equals(s) && numOfFruits == s.getNumOfFruits() && addProtein == s.getAddProtein()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// Getters and Setters
	public int getNumOfFruits() {
		return numOfFruits;
	}

	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}

	public boolean getAddProtein() {
		return addProtein;
	}

	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}

	public double getFRUIT_COST() {
		return FRUIT_COST;
	}

	public double getPROTEIN_COST() {
		return PROTEIN_COST;
	}
	
	// End Getters and Setters
	
	
	/**
	 * An Overridden calcPrice method
	 */
	public double calcPrice() {
		double p = super.getBasePrice();
		
		if(super.getSize() == SIZE.MEDIUM) {
			p += super.getSizePrice();
		} else if(super.getSize() == SIZE.LARGE) {
			p += 2 * super.getSizePrice();
		}
		
		p += numOfFruits * FRUIT_COST;
		
		if(addProtein == true) {
			p += PROTEIN_COST;
		}
		
		return p;
	}
	
	
	

}
