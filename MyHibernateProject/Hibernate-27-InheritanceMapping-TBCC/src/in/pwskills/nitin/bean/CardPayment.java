package in.pwskills.nitin.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Card_Payment")
public class CardPayment extends Payment{
	static {
		System.out.println("CardPayment.class() is Loading");
	}
	public CardPayment() {
		System.out.println("CardPayment.CardPayment() is initialization");
	}
	private Long cardNo;
	private String cardType;
	private String paymentGateWay;
	public Long getCardNo() {
		return cardNo;
	}
	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getPaymentGateWay() {
		return paymentGateWay;
	}
	public void setPaymentGateWay(String paymentGateWay) {
		this.paymentGateWay = paymentGateWay;
	}
	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", paymentGateWay=" + paymentGateWay + "]";
	}

}
