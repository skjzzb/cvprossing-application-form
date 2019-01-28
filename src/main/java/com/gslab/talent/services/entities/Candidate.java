package com.gslab.talent.services.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the candidate database table.
 * 
 */
@Entity
@Table(name="candidate")
@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")
@NamedQuery(name="Candidate.countByEvaluationstatus", query="SELECT count(*) FROM Candidate WHERE candidate_evaluation_status = :id")
@NamedQuery(name="Candidate.countAllByReject", query="SELECT count(*) FROM Candidate WHERE candidate_evaluation_status IN ( :ids ) GROUP BY candidate_id ORDER BY candidate_id")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name="TABLE_GEN",table="T_GENERATOR", pkColumnName = "IDS", pkColumnValue = "CANDIDATE.CANDIDATE_ID", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GEN")
	private long candidateId;

	@Column(name="candidate_contact", nullable=false)
	private long candidateContact;

	@Column(name="candidate_current_company", length=45)
	private String candidateCurrentCompany;

	@Column(name="candidate_email", nullable=false, length=45)
	private String candidateEmail;

	@Column(name="candidate_name", nullable=false, length=45)
	private String candidateName;

	@Column(name="candidate_profile_storage_url", length=45)
	private String candidateProfileStorageUrl;

	@Column(name="candidate_technology_stack", length=45)
	private String candidateTechnologyStack;

	@Column(name="candidate_years_ex")
	private int candidateYearsEx;
	
	@Basic(optional = false)
	@Column(name = "create_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name="create_user", length=20)
	private String createUser;

	@Basic(optional = false)
	@Column(name = "update_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	@Column(name="update_user", length=20)
	private String updateUser;

	//bi-directional many-to-one association to Evaluationstatus
	@ManyToOne
	@JoinColumn(name="candidate_evaluation_status")
	private Evaluationstatus evaluationstatus;

	//bi-directional many-to-one association to Isavailableforinterview
	@ManyToOne
	@JoinColumn(name="is_available_for_interview")
	private Isavailableforinterview isavailableforinterview;

	//bi-directional many-to-one association to Position
	@ManyToOne
	@JoinColumn(name="gs_position", nullable=false)
	private Position position;

	//bi-directional many-to-one association to Evaluationprogress
	/*
	 * @OneToMany(mappedBy="candidate") private List<Evaluationprogress>
	 * evaluationprogresses;
	 */

	public Candidate() {
	}

	public long getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public long getCandidateContact() {
		return this.candidateContact;
	}

	public void setCandidateContact(long candidateContact) {
		this.candidateContact = candidateContact;
	}

	public String getCandidateCurrentCompany() {
		return this.candidateCurrentCompany;
	}

	public void setCandidateCurrentCompany(String candidateCurrentCompany) {
		this.candidateCurrentCompany = candidateCurrentCompany;
	}

	public String getCandidateEmail() {
		return this.candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

	public String getCandidateName() {
		return this.candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateProfileStorageUrl() {
		return this.candidateProfileStorageUrl;
	}

	public void setCandidateProfileStorageUrl(String candidateProfileStorageUrl) {
		this.candidateProfileStorageUrl = candidateProfileStorageUrl;
	}

	public String getCandidateTechnologyStack() {
		return this.candidateTechnologyStack;
	}

	public void setCandidateTechnologyStack(String candidateTechnologyStack) {
		this.candidateTechnologyStack = candidateTechnologyStack;
	}

	public int getCandidateYearsEx() {
		return this.candidateYearsEx;
	}

	public void setCandidateYearsEx(int candidateYearsEx) {
		this.candidateYearsEx = candidateYearsEx;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Evaluationstatus getEvaluationstatus() {
		return this.evaluationstatus;
	}

	public void setEvaluationstatus(Evaluationstatus evaluationstatus) {
		this.evaluationstatus = evaluationstatus;
	}

	public Isavailableforinterview getIsavailableforinterview() {
		return this.isavailableforinterview;
	}

	public void setIsavailableforinterview(Isavailableforinterview isavailableforinterview) {
		this.isavailableforinterview = isavailableforinterview;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	/*
	 * public List<Evaluationprogress> getEvaluationprogresses() { return
	 * this.evaluationprogresses; }
	 * 
	 * public void setEvaluationprogresses(List<Evaluationprogress>
	 * evaluationprogresses) { this.evaluationprogresses = evaluationprogresses; }
	 */

	/*
	 * public Evaluationprogress addEvaluationprogress(Evaluationprogress
	 * evaluationprogress) { getEvaluationprogresses().add(evaluationprogress);
	 * evaluationprogress.setCandidate(this);
	 * 
	 * return evaluationprogress; }
	 * 
	 * public Evaluationprogress removeEvaluationprogress(Evaluationprogress
	 * evaluationprogress) { getEvaluationprogresses().remove(evaluationprogress);
	 * evaluationprogress.setCandidate(null);
	 * 
	 * return evaluationprogress; }
	 */

}