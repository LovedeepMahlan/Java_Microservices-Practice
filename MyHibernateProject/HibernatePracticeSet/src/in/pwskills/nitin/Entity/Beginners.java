package in.pwskills.nitin.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BeginnerWorkers")
public class Beginners {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int workerid;
	
	@Column(name="workerName",length=20)
	String name;
	
	@Column(name="personAge")
	String age;

	public int getWorkerid() {
		return workerid;
	}

	public void setWorkerid(int workerid) {
		this.workerid = workerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Beginners [workerid=" + workerid + ", name=" + name + ", age=" + age + "]";
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
}
