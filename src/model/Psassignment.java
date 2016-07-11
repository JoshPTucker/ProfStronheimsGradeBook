package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PSASSIGNMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Psassignment.findAll", query="SELECT p FROM Psassignment p")
public class Psassignment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PSASSIGNMENT_ASSIGNMENTID_GENERATOR", sequenceName="PSASSIGNMENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSASSIGNMENT_ASSIGNMENTID_GENERATOR")
	private long assignmentid;

	@Temporal(TemporalType.DATE)
	private Date assigneddate;

	private String assignmentname;

	private String assignmenttype;

	private BigDecimal score;

	//bi-directional many-to-one association to Psstudent
	@ManyToOne
	@JoinColumn(name="STUDENTID")
	private Psstudent psstudent;

	public Psassignment() {
	}

	public long getAssignmentid() {
		return this.assignmentid;
	}

	public void setAssignmentid(long assignmentid) {
		this.assignmentid = assignmentid;
	}

	public Date getAssigneddate() {
		return this.assigneddate;
	}

	public void setAssigneddate(Date assigneddate) {
		this.assigneddate = assigneddate;
	}

	public String getAssignmentname() {
		return this.assignmentname;
	}

	public void setAssignmentname(String assignmentname) {
		this.assignmentname = assignmentname;
	}

	public String getAssignmenttype() {
		return this.assignmenttype;
	}

	public void setAssignmenttype(String assignmenttype) {
		this.assignmenttype = assignmenttype;
	}

	public BigDecimal getScore() {
		return this.score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public Psstudent getPsstudent() {
		return this.psstudent;
	}

	public void setPsstudent(Psstudent psstudent) {
		this.psstudent = psstudent;
	}

}