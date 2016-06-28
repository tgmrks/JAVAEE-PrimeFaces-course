import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class EmployeeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static final String[] names = { "João", "Maria", "José", "Eduardo", "Sebastião", "Mariana", "Francisco",
		"Manoel", "Fernanda", "Gabriela", "Mário", "Marcos" };
	
	private static final String[] surenames = { "Souza", "Silva", "Andrade", "Machado", "Júnior", "Albuquerque",
		"Alencar", "Assis", "Batista", "Camargo", "Coelho", "Costa", "Dias", "Rosa", "Leal", "Lima", "Leite" };
	
	private List<Employee> employees;

	public EmployeeBean() throws ParseException {
		employees = new ArrayList<>();
		
		for (int i = 0; i < 50; i++) {
			addEmp();
		}
	}
	
	private void addEmp() {
		String completeName = getRandomName() + " " + getRandomSurename() + " " + getRandomSurename();
		employees.add(new Employee(getRandomReg(), completeName, getRambomDate(), 
				getSalarioAleatorio()));
	}
	
	private Double getSalarioAleatorio() {
		System.out.println(new Double(1000 + (Math.random() * 29000)));
		return new Double(1000 + (Math.random() * 29000));
	}
	
	private Long getRandomReg() {
		return (long) (Math.random() * 10000);
	}
	
	private Date getRambomDate() {
		long tenYearsMills = 24 * 60 * 60 * 1000;
		long periodMills = ((long) (Math.random() * 10 * 365)) * tenYearsMills;
		System.out.println(new Date(System.currentTimeMillis() - periodMills));
		return new Date(System.currentTimeMillis() - periodMills);
	}
	
	private String getRandomSurename() {
		int position = (int) Math.round(Math.random() * (surenames.length - 1));
		return surenames[position];
	}
	
	private String getRandomName() {
		int position = (int) Math.round(Math.random() * (names.length - 1));
		return names[position];
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
}
