package in.lingtan.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PayRoll {
	private int ctc;
	
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	public int getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(int basiPay) {
		this.basicPay = basiPay;
	}
	public int getPfAllowance() {
		return pfAllowance;
	}
	public void setPfAllowance(int pfAllowance) {
		this.pfAllowance = pfAllowance;
	}
	public int getMedicalAllowance() {
		return medicalAllowance;
	}
	public void setMedicalAllowance(int medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}
	public int getTravelAllowance() {
		return travelAllowance;
	}
	public void setTravelAllowance(int travelAllowance) {
		this.travelAllowance = travelAllowance;
	}
	public int getHraAllowance() {
		return hraAllowance;
	}
	public void setHraAllowance(int hraAllowance) {
		this.hraAllowance = hraAllowance;
	}
	public int getFoodAllowance() {
		return foodAllowance;
	}
	public void setFoodAllowance(int foodAllowance) {
		this.foodAllowance = foodAllowance;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	private int basicPay ;
	private int pfPercentage;
	public int getPfPercentage() {
		return pfPercentage;
	}
	public void setPfPercentage(int pfPercentage) {
		this.pfPercentage = pfPercentage;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	private int salary;
	@Override
	public String toString() {
		return "PayRoll [ctc=" + ctc + ", basicPay=" + basicPay + ", pfPercentage=" + pfPercentage + ", salary="
				+ salary + ", employee=" + employee + ", pfAllowance=" + pfAllowance + ", medicalAllowance="
				+ medicalAllowance + ", travelAllowance=" + travelAllowance + ", hraAllowance=" + hraAllowance
				+ ", foodAllowance=" + foodAllowance + ", role=" + role + "]";
	}
	
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	private int pfAllowance ;
	private int medicalAllowance ;
	private int travelAllowance ;
	private int hraAllowance ;
	private int foodAllowance ;
	private String role;
}
