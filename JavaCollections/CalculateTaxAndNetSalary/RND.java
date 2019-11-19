package collections;

public class RND extends Department {
	
	RND(String name, String lastName, int salary){
		super(name, lastName, salary);
	}
	
	public String getDetails() {
		return "RND: " +super.getName()+" "+super.getLastName()+"\t"+"Gross: "+super.getSalaryBeforeTax()+"\t"+"Tax: "+super.getTax()+"\t"+"Net: "+super.getSalaryAfterTax();
	}
}
