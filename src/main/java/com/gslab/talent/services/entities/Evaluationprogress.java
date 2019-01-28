package com.gslab.talent.services.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the evaluationprogress database table.
 * 
 */
@Entity
@Table(name="evaluationprogress")
@NamedQuery(name="Evaluationprogress.findAll", query="SELECT e FROM Evaluationprogress e")
public class Evaluationprogress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="evaluation_progress_id", unique=true, nullable=false)
	private int evaluationProgressId;

	@Column(name="candidate_feedback_gdrive_url", length=45)
	private String candidateFeedbackGdriveUrl;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="created_user", length=45)
	private String createdUser;

	@Column(name="seculded_datetime")
	private Timestamp seculdedDatetime;

	@Column(name="send_calendar_invite_panel", length=45)
	private String sendCalendarInvitePanel;

	@Column(name="send_email_panel", length=45)
	private String sendEmailPanel;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="update_user", length=45)
	private String updateUser;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="candidate_ev_id", nullable=false)
	private Candidate candidate;

	//bi-directional many-to-one association to Evaluationstatus
	@ManyToOne
	@JoinColumn(name="evaluation_status")
	private Evaluationstatus evaluationstatus;

	//bi-directional many-to-one association to Interviewerlevel
	@ManyToOne
	@JoinColumn(name="evaluation_interviewer_level")
	private Interviewerlevel interviewerlevel;

	//bi-directional many-to-one association to Modeofinterview
	@ManyToOne
	@JoinColumn(name="evaluation_mode_of_interview")
	private Modeofinterview modeofinterview;

	//bi-directional many-to-one association to Panelmember
	@ManyToOne
	@JoinColumn(name="evaluation_panel")
	private Panelmember panelmember;

	public Evaluationprogress() {
	}

	public int getEvaluationProgressId() {
		return this.evaluationProgressId;
	}

	public void setEvaluationProgressId(int evaluationProgressId) {
		this.evaluationProgressId = evaluationProgressId;
	}

	public String getCandidateFeedbackGdriveUrl() {
		return this.candidateFeedbackGdriveUrl;
	}

	public void setCandidateFeedbackGdriveUrl(String candidateFeedbackGdriveUrl) {
		this.candidateFeedbackGdriveUrl = candidateFeedbackGdriveUrl;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedUser() {
		return this.createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Timestamp getSeculdedDatetime() {
		return this.seculdedDatetime;
	}

	public void setSeculdedDatetime(Timestamp seculdedDatetime) {
		this.seculdedDatetime = seculdedDatetime;
	}

	public String getSendCalendarInvitePanel() {
		return this.sendCalendarInvitePanel;
	}

	public void setSendCalendarInvitePanel(String sendCalendarInvitePanel) {
		this.sendCalendarInvitePanel = sendCalendarInvitePanel;
	}

	public String getSendEmailPanel() {
		return this.sendEmailPanel;
	}

	public void setSendEmailPanel(String sendEmailPanel) {
		this.sendEmailPanel = sendEmailPanel;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Evaluationstatus getEvaluationstatus() {
		return this.evaluationstatus;
	}

	public void setEvaluationstatus(Evaluationstatus evaluationstatus) {
		this.evaluationstatus = evaluationstatus;
	}

	public Interviewerlevel getInterviewerlevel() {
		return this.interviewerlevel;
	}

	public void setInterviewerlevel(Interviewerlevel interviewerlevel) {
		this.interviewerlevel = interviewerlevel;
	}

	public Modeofinterview getModeofinterview() {
		return this.modeofinterview;
	}

	public void setModeofinterview(Modeofinterview modeofinterview) {
		this.modeofinterview = modeofinterview;
	}

	public Panelmember getPanelmember() {
		return this.panelmember;
	}

	public void setPanelmember(Panelmember panelmember) {
		this.panelmember = panelmember;
	}

}