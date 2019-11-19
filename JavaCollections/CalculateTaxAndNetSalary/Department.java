package collections;

public class Department {
	private String name;
	private String lastName;
	private float salary = 0;
	public float totalTax;
	
	Department(String name, String lastName, int salary){
		this.setName(name);
		this.setLastName(lastName);
		this.salary = salary;
	}
	
	public void setName(String myName) {
		if (myName == null || myName.contentEquals(""))
			name = "No name";
		else
			name = myName;
	}
	
	public void setLastName(String myLastName) {
		if (myLastName == null || myLastName.contentEquals(""))
			lastName = "No Last Name";
		else
			lastName = myLastName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public float getSalaryBeforeTax() {
		return salary;
	}
	
	public float getTax() {
		
		if (salary > 0 && salary <= 5000) 
		    totalTax = salary * 0.15f;
		
		else if (salary > 5000 && salary <= 7000) 
			totalTax = (5000 * 0.15f) + (salary - 5000) * 0.25f;
		
		else if (salary > 7000 && salary <= 10000) 
			totalTax = (5000 * 0.15f) + (2000 * 0.25f) + (salary - 7000) * 0.35f;
		
		else if (salary > 10000) 
			totalTax = (5000 * 0.15f) + (2000 * 0.25f) + (3000 * 0.35f) + (salary - 10000) * 0.45f;
		
		return totalTax;
	}
	
	public float getSalaryAfterTax() {
		return salary - totalTax;
	}
	
	public String getDetails() {
		return "Department: " + getName() + getLastName() + getSalaryBeforeTax() + getTax() + getSalaryAfterTax();
	}
}
