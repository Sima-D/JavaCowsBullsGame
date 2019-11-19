package collections;

public class QA extends Department {
	
	QA(String name, String lastName, int salary){
		super(name, lastName, salary);
	}
	
	public String getDetails() {
		return "QA: " +super.getName()+" "+super.getLastName()+"\t"+"Gross: "+super.getSalaryBeforeTax()+"\t"+"Tax: "+super.getTax()+"\t"+"Net: "+super.getSalaryAfterTax();
	}
}
