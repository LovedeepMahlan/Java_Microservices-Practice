package in.pwskills.nitin.bean;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CardPayment") 
public class CardPayment extends Payment {

    static {
        System.out.println("CardPayment.class() is Loading");
    }

    public CardPayment() {
        System.out.println("CardPayment.CardPayment() is initialization");
    }

    @Column(name = "cardNo")
    private Long cardNo;

    @Column(name = "cardType")
    private String cardType;

    @Column(name = "paymentGateway")
    private String paymentGateway;

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

    public String getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(String paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public String toString() {
        return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", paymentGateway=" + paymentGateway + "]";
    }
}
