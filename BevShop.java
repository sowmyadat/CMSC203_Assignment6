import java.util.ArrayList;

import javax.swing.plaf.basic.BasicBorders;

public class BevShop implements BevShopInterface {

	private int NumAlcOrder;
	private int currentOrder;
	private ArrayList<Order> orders;
	
	/**
	 * Default Constructor
	 */
	public BevShop() {
		orders = new ArrayList<>();
	}
	
	/**
	 * An Overridden toString method: The string representation of all the
	 * orders and the total monthly sale.
	 */
	@Override
	public String toString() {
		String theString = "Monthly Orders\n";
		
		for(Order order : orders) {
			theString += order.toString();
		}
		
		theString += "Total Sale: " + totalMonthlySale();
		
		return theString;
	}
	
	/**
	 * Checks if the time is valid (between 8 and 23 )
	 *
	 * @param time
	 *            time represents the time
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	@Override
	public boolean validTime(int time) {
		if(time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		return false;
	}

	
	/**
	 * Returns the max amount of fruit
	 */
	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	/**
	 * returns the constant value for the Minimum age for offering Alcohol drink
	 *
	 * @return returns the value for the minimum age for offering Alcohol drink
	 */
	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	/**
	 * returns true if the passed parameter exceeds the Maximum FRUIT allowed
	 *
	 * @param numOfFruits
	 *            number of fruits
	 * @return true if the passed parameter exceeds the MAXIUM number of fruits
	 *         allowed for the SMOTHIE drink, false otherwise
	 */
	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits > MAX_FRUIT) {
			return true;
		}
		return false;
	}

	/**
	 * returns constant maximum number of alcohol beverages/per order offered by
	 * the beverage shop
	 *
	 * @return constant maximum number of alcohol beverages/per order offered by
	 *         the beverage shop
	 */
	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	/**
	 * checks if the number of alcohol beverages for the current order has
	 * reached the maximum
	 *
	 * @return true if number of alcohol drinks for the current order has
	 *         reached the maximum , false otherwise
	 */
	@Override
	public boolean eligibleForMore() {
		if(getNumOfAlcoholDrink() < 3) {
			return true;
		}
		return false;
	}

	/**
	 * returns the number of alcohol drinks for the current order
	 *
	 * @return returns the number of alcohol drinks for the current order
	 */
	@Override
	public int getNumOfAlcoholDrink() {
		return NumAlcOrder;
	}

	/**
	 * check the valid age for the alcohol drink
	 *
	 * @param age - the age
	 * @return returns true if age is more than minimum eligible age , false
	 *         otherwise
	 */
	@Override
	public boolean validAge(int age) {
		if(age >= MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}

	/**
	 * Creates a new order , NO BEVERAGE is added to the order yet
	 *
	 * @param time
	 *            time of the order
	 * @param day
	 *            day of the order of type DAY
	 * @param customerName
	 *            customer name
	 * @param customerAge
	 *            customer age
	 */
	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		
		orders.add(order);
		
		currentOrder = orders.indexOf(order);
		NumAlcOrder = 0;
		
	}

	/**
	 * process the Coffee order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param extraShot
	 *            true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup
	 *            true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orders.get(currentOrder).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	/**
	 * process the Alcohol order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 */
	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		orders.get(currentOrder).addNewBeverage(bevName, size);
		NumAlcOrder++;
		
	}

	/**
	 * process the Smoothie order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param numOfFruits
	 *            number of fruits to be added
	 * @param addProtien
	 *            true if protein is added , false otherwise
	 */
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		orders.get(currentOrder).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	/**
	 * locate an order based on the order number
	 *
	 * @param orderNo
	 *            the order number
	 * @return the index of the order in the list of Orders if found or -1 if
	 *         not found
	 */
	@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		
		return -1;
	}

	/**
	 * locates an order in the list of orders and returns the total value on the
	 * order.
	 *
	 * @param orderNo
	 *            the order number
	 * @returns the calculated price on this order.
	 */
	@Override
	public double totalOrderPrice(int orderNo) {
		double total = 0;
		
		for(Order order : orders ) {
			if(order.getOrderNo() == orderNo) {
				for(Beverage beverage : order.getBevs()) {
					total += beverage.calcPrice();
				}
			}
		}
		
		return total;
	}

	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 *
	 * @return the total sale of all the orders
	 */
	@Override
	public double totalMonthlySale() {
		double total = 0;
		
		for(Order order : orders ) {
			for(Beverage beverage : order.getBevs()) {
				total += beverage.calcPrice();
			}
		}
		
		return total;
	}

	/**
	 * returns total numbers of orders within the month
	 *
	 * @returns total numbers of orders within the month
	 */
	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	/**
	 * returns the current Order located in the index in the list of orders.
	 * Notes: this method returns the shallow copy of the order
	 *
	 * @return the current order
	 */
	@Override
	public Order getCurrentOrder() {
		return orders.get(currentOrder);
	}

	/**
	 * returns Order in the list of orders at the index Notes: this method
	 * returns the shallow copy of the order
	 *
	 * @return Order in the list of orders at the index
	 */
	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	/**
	 * sorts the orders within this bevShop using the Selection sort algorithm
	 */
	@Override
	public void sortOrders() {
		for(int i = 0; i < orders.size() - 1; i++) {
			int min = i;
			
			for(int j = i + 1; j < orders.size(); j++) {
				if(orders.get(j).getOrderNo() < orders.get(min).getOrderNo()) {
					min = j;
				}
			}
			
			Order x = orders.get(min);
			orders.set(min, orders.get(i));
			orders.set(i, x);
		}
	}
	
	// Getters and Setters
	public int getNumAlcOrder() {
		return NumAlcOrder;
	}

	public void setNumAlcOrder(int numAlcOrder) {
		NumAlcOrder = numAlcOrder;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public void setCurrentOrder(int currentOrder) {
		this.currentOrder = currentOrder;
	}
	// End Getters and Setters

}
