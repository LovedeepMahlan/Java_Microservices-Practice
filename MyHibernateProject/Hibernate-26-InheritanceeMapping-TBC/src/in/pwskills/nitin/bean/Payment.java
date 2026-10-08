package in.pwskills.nitin.bean;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name = "paymentMode", discriminatorType = DiscriminatorType.STRING, length = 20)
public class Payment {

    static {
        System.out.println("Payment class is Loading");
    }

    public Payment() {
        System.out.println("Payment.class is Initialization");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private Float amount;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment [pid=" + pid + ", amount=" + amount + "]";
    }
}
