
public class Customer {
	private String name;
	private int age;
	
	/**
	 * Parametrized constructor
	 * 
	 * @param name
	 * @param age
	 */
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Copy constructor
	 * 
	 * @param c
	 */
	public Customer(Customer c) {
		this.name = c.getName();
		this.age = c.getAge();
	}

	
	// Getters and Setters 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// End Getters and Setters
	
	/**
	 * An Overridden toString method: String representation for Customer including the name and age
	 */
	@Override
	public String toString() {
		return name + ", " + age + "years old";
	}
	
}
