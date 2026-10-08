package in.pwskills.nitin.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProgramProjID implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer progid;
	private Integer projid;
	public Integer getProgid() {
		return progid;
	}
	public void setProgid(Integer progid) {
		this.progid = progid;
	}
	public Integer getProjid() {
		return projid;
	}
	public void setProjid(Integer projid) {
		this.projid = projid;
	}
	@Override
	public String toString() {
		return "ProgramProjID [progid=" + progid + ", projid=" + projid + "]";
	}
}
