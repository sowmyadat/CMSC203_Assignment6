import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{
	private int number;
	private int time;
	private DAY day; 
	private Customer customer;
	private ArrayList<Beverage> bevs;
	
	/**
	 * Parametrized constructor
	 * 
	 * @param time
	 * @param day
	 * @param c
	 */
	public Order(int time, DAY day, Customer c) {
		number = genOrderNumber();
		this.time = time;
		this.day = day;
		customer = c;
		bevs = new ArrayList<>();
	}
	
	/**
	 * A method to generate a raondom order number within the range of 10000 and 90000
	 * 
	 * @return
	 */
	public int genOrderNumber() {
		Random r = new Random(); 
		
		int calc = r.nextInt(90000-10000) + 10000;
		
		return calc;
	}
	
	/**
	 * An Overridden toString method: Includes order number, time, day, customer name, customer age and the
	 * list of beverages (with information of the beverage)
	 */
	@Override
	public String toString() {
		String x = day.toString() +", " + time + "\n" + customer.toString() + " Order Number: " + number;
		
		for (Beverage b : bevs) {
			x += "\n" + b.toString();
		}
		
		x += "\n Order Total: " + calcOrderTotal();
		return x; 
	}
	
	/**
	 * Override the compareTo method to compare this order with another order based on the order
	 * number. 
	 * 
	 * @return - 0 if this order number is the same as another order's number, 1 if it is greater than 
	 * another order's number, -1 if it's smaller than another order's number.
	 */
	@Override
	public int compareTo(Order o) {
		if(number == o.getOrderNo()) {
			return 0;
		} else if(number > o.getOrderNo()) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 *
	 * @param no parameters
	 * @return true if the day is a weekend day (Saturday or Sunday)
	 */
	@Override
	public boolean isWeekend() {
		if(day == DAY.SUNDAY || day == DAY.SATURDAY) {
			return true;
		}
		return false;
	}

	/**
	 * returns the beverage listed in the itemNo of the order, for example if
	 * itemNo is 0 this method will return the first beverage in the order
	 * Note: this method returns the shallow copy of the Beverage
	 *
	 * @return the beverage listed in the itemNo of the order or null if there
	 *         is no item in the order
	 *
	 */
	@Override
	public Beverage getBeverage(int itemNo) {
		return bevs.get(itemNo);
	}

	/**
	 * adds coffee order to this order
	 * 
	 * @param bevName beverage name
	 * @param size beverage size of type SIZE
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		bevs.add(coffee);
	}

	/**
	 * adds alcohol order to this order
	 * 
	 * @param bevName beverage name
	 * @param size beverage size
	 */
	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		boolean isWeek = isWeekend();
		
		Alcohol alcohol = new Alcohol(bevName, size, isWeek);
		
		bevs.add(alcohol);
	}

	/**
	 * Adds the Smoothie beverage to this order
	 * 
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits added
	 * @param addPRotien true if protein is added, false otherwise
	 */
	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addPRotien);
		
		bevs.add(smoothie);
	}

	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	@Override
	public double calcOrderTotal() {
		double total = 0;
		
		for(Beverage b : bevs) {
			total += b.calcPrice();
		}
		
		return total;
	}

	/**
	 * returns the number of beverages of same type in an order
	 * @param type the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	@Override
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		
		for(Beverage b : bevs) {
			if(b.getType() == type) {
				count++;
			}
		}
		
		return count;
	}
	
	// Getters and Setters
	public int getOrderNo() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getOrderTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public DAY getOrderDay() {
		return day;
	}

	public void setDay(DAY day) {
		this.day = day;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Beverage> getBevs() {
		return bevs;
	}

	public void setBevs(ArrayList<Beverage> bevs) {
		this.bevs = bevs;
	}
	
	public int getTotalItems() {
		return bevs.size();
	}
	// End Getters and Setters
}
