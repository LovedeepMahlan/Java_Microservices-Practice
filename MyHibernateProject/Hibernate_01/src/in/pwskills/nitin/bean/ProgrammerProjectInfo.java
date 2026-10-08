package in.pwskills.nitin.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Project_info")
public class ProgrammerProjectInfo {
	
	@EmbeddedId
	private ProgramProjID id;
	@Column(name="ProgrammerName",length=30)
	private String ProgrammerName;
	@Column(name="ProjName",length=30)
	private String ProjectName;
	
	public ProgramProjID getId() {
		return id;
	}
	@Override
	public String toString() {
		return "ProgrammerProjectInfo [id=" + id + ", ProgrammerName=" + ProgrammerName + ", ProjectName=" + ProjectName
				+ "]";
	}
	public void setId(ProgramProjID id) {
		this.id = id;
	}
	public String getProgrammerName() {
		return ProgrammerName;
	}
	public void setProgrammerName(String programmerName) {
		ProgrammerName = programmerName;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

}
