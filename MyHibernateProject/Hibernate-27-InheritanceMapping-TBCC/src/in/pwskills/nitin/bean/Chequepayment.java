package in.pwskills.nitin.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Cheque_Payment")
public class Chequepayment extends Payment {

	static {
		System.out.println("Chequepayment.enclosing_method() is initiaization");
	}
	public Chequepayment() {
		System.out.println("Chequepayment.Chequepayment() is initialization");
	}
	
	private Long chequeNo;
	private String chequeType;
	private LocalDate expriyDate;
	@Override
	public String toString() {
		return "Chequepayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expriyDate=" + expriyDate
				+ "]";
	}
	public Long getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	public LocalDate getExpriyDate() {
		return expriyDate;
	}
	public void setExpriyDate(LocalDate expriyDate) {
		this.expriyDate = expriyDate;
	}

	
	
}
