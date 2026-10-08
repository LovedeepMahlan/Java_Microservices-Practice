package in.pwskills.nitin.bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Entity
@Table(name = "Student_Info")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;

    @Column(name = "sname",length = 30)
    private String sname;

    @Column(name = "sage")
    private Integer sage;

    @Column(name = "saddress",length=30)
    private String saddress;

    @Override
    public String toString() {
        return "Student [sname=" + sname + ", sid=" + sid + ", sage=" + sage + ", saddress=" + saddress + "]";
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    static {
        System.out.println("Student.class file is loading");
    }

    public Student() {
        System.out.println("Student with zero parameter");
    }
}
