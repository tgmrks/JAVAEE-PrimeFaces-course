import java.io.Serializable;
import java.util.Date;


public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long reg;
	private String name;
	private Date dateHired;
	private Double salary;

	public Employee(Long reg, String name, Date dateHired, Double salary) {
		this.reg = reg;
		this.name = name;
		this.dateHired = dateHired;
		this.salary = salary;
	}
	

	public Long getReg() {
		return reg;
	}

	public void setReg(Long reg) {
		this.reg = reg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dataHired) {
		this.dateHired = dataHired;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
