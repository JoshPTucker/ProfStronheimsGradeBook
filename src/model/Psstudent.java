package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PSSTUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Psstudent.findAll", query="SELECT p FROM Psstudent p")
public class Psstudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PSSTUDENT_STUDENTID_GENERATOR", sequenceName="PSSTUDENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSSTUDENT_STUDENTID_GENERATOR")
	private long studentid;

	private String firstname;

	private BigDecimal gradeavg;

	private String lastname;

	//bi-directional many-to-one association to Psassignment
	@OneToMany(mappedBy="psstudent")
	private List<Psassignment> psassignments;

	public Psstudent() {
	}

	public long getStudentid() {
		return this.studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public BigDecimal getGradeavg() {
		return this.gradeavg;
	}

	public void setGradeavg(BigDecimal gradeavg) {
		this.gradeavg = gradeavg;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Psassignment> getPsassignments() {
		return this.psassignments;
	}

	public void setPsassignments(List<Psassignment> psassignments) {
		this.psassignments = psassignments;
	}

	public Psassignment addPsassignment(Psassignment psassignment) {
		getPsassignments().add(psassignment);
		psassignment.setPsstudent(this);

		return psassignment;
	}

	public Psassignment removePsassignment(Psassignment psassignment) {
		getPsassignments().remove(psassignment);
		psassignment.setPsstudent(null);

		return psassignment;
	}

}