import org.junit.validator.PublicClassValidator;

import javafx.scene.layout.BackgroundRepeat;

/**
 * 
 * @author Sowmya Datla
 *
 */
abstract class Beverage {
	private String name;
	private TYPE type;
	private SIZE size;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1.0;
	
	/**
	 * Parametrized constructor to create a Beverage object given its name, type and size.
	 * 
	 * @param name
	 * @param type
	 * @param size
	 */
	public Beverage(String name, TYPE type, SIZE size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	/**
	 * An abstract method that calculates and returns the beverage price.
	 * 
	 * @return
	 */
	abstract double calcPrice();
	
	/**
	 * An Overridden toString method: String representation for Beverage including the name
	 * and size.
	 */
	@Override
	public String toString() {
		return name + ", " + size;
	}
	
	/**
	 * An Overridden equals method: checks equality based on name, type, size of beverage.
	 * 
	 * @param b
	 * @return
	 */
	public boolean equals(Beverage b) {
		if(type == b.getType() && size == b.getSize() && name.equals(b.getBevName())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Gets the name of the Beverage
	 * 
	 * @return - name of beverage
	 */
	public String getBevName() {
		return name;
	}
	
	/**
	 * Gets the type of the Beverage
	 * 
	 * @return - type of beverage
	 */
	public TYPE getType() {
		return type;
	}
	
	/**
	 * Gets the size of the Beverage
	 * 
	 * @return - size of beverage
	 */
	public SIZE getSize() {
		return size;
	}
	
	/**
	 * Gets the base price of the beverage
	 * 
	 * @return - base price of the beverage
	 */
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	/**
	 * Gets the size price of the beverage
	 * 
	 * @return - size price of the beverage
	 */
	public double getSizePrice() {
		return SIZE_PRICE;
	}
	
	/**
	 * Sets the name of the beverage
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the type of the beverage
	 * 
	 * @param type
	 */
	public void setType(TYPE type) {
		this.type = type;
	}
	
	/**
	 * Sets the size of the beverage
	 * 
	 * @param size
	 */
	public void setSize(SIZE size) {
		this.size = size;
	}
	
}
