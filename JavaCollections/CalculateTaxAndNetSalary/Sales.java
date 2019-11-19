package collections;

public class Sales extends Department {
	
	Sales(String name, String lastName, int salary){
		super(name, lastName, salary);
	}
	
	public String getDetails() {
		return "SALES: " +super.getName()+" "+super.getLastName()+"\t"+"Gross: "+super.getSalaryBeforeTax()+"\t"+"Tax: "+super.getTax()+"\t"+"Net: "+super.getSalaryAfterTax();
	}
}
