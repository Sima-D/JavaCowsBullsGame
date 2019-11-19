package collections;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ThreeDepartments_main {

	public static void main(String[] args) {
		List<Department> employees = new ArrayList<Department>();
		int answer = 0;

		do {
			String depStr = JOptionPane.showInputDialog(null,  "Please enter department name: SALES/QA/RND", "CHOOSE DEPARTMENT", JOptionPane.PLAIN_MESSAGE);
			String nameStr = JOptionPane.showInputDialog(null, "Please enter your first name: ", depStr.toUpperCase()+" DEPARTMENT", JOptionPane.PLAIN_MESSAGE);
			String lastNameStr = JOptionPane.showInputDialog(null, "Please enter your last name: ", depStr.toUpperCase()+" DEPARTMENT", JOptionPane.PLAIN_MESSAGE);
			String salaryStr = JOptionPane.showInputDialog(null, "Please enter your salary: ", depStr.toUpperCase()+" DEPARTMENT", JOptionPane.PLAIN_MESSAGE);	
			int salary = (int)Integer.parseInt(salaryStr);	
			
			if (depStr.equalsIgnoreCase("Sales")) {
				employees.add(new Sales(nameStr, lastNameStr, salary));
			}	
			else if (depStr.equalsIgnoreCase("QA")) {
				employees.add(new QA(nameStr, lastNameStr, salary));
			}
			else if (depStr.equalsIgnoreCase("RND")) {
				employees.add(new RND(nameStr, lastNameStr, salary));
			}
			
			answer = JOptionPane.showConfirmDialog(null, "Would you like to enter the next employee?", "YES/NO QUESTION", JOptionPane.YES_NO_OPTION);
		} while (answer == JOptionPane.YES_OPTION);
		
		printEmployees(employees);
		System.exit(0);
	}
	
	private static void printEmployees(List <Department> employees) {
		for (Department d: employees) {
			System.out.println(d.getDetails());
		}
	}		
}
