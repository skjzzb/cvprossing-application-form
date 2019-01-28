package com.gslab.talent.services.model;

import java.time.LocalDateTime;

public class EvaluationProgress {
	
	private Integer evaluationProgressId;
	private String interviewerLevel;
	private String panelName;
	private String modeOfInterview;
	private LocalDateTime seculdedDateAndTime;
	private String interviewStatus;
	private Boolean sendAnEmailToPanel;
	private Boolean sendCalendarInviteToPanel;
	
	//TODO: Need to add extra feture here such as feedback form or rating stuff
	private StringBuffer candidateFeedBack;
	private Integer InterviewCandidateEvaluationId;

	public EvaluationProgress(Integer evaluationProgressId, String interviewerLevel, String panelName,
			String modeOfInterview, LocalDateTime seculdedDateAndTime, String interviewStatus,
			Boolean sendAnEmailToPanel, Boolean sendCalendarInviteToPanel, StringBuffer candidateFeedBack,
			Integer interviewCandidateEvaluationId) {
		super();
		this.evaluationProgressId = evaluationProgressId;
		this.interviewerLevel = interviewerLevel;
		this.panelName = panelName;
		this.modeOfInterview = modeOfInterview;
		this.seculdedDateAndTime = seculdedDateAndTime;
		this.interviewStatus = interviewStatus;
		this.sendAnEmailToPanel = sendAnEmailToPanel;
		this.sendCalendarInviteToPanel = sendCalendarInviteToPanel;
		this.candidateFeedBack = candidateFeedBack;
		this.InterviewCandidateEvaluationId = interviewCandidateEvaluationId;
	}

	public Integer getEvaluationProgressId() {
		return evaluationProgressId;
	}

	public void setEvaluationProgressId(Integer evaluationProgressId) {
		this.evaluationProgressId = evaluationProgressId;
	}

	public String getInterviewerLevel() {
		return interviewerLevel;
	}

	public void setInterviewerLevel(String interviewerLevel) {
		this.interviewerLevel = interviewerLevel;
	}

	public String getPanelName() {
		return panelName;
	}

	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}

	public String getModeOfInterview() {
		return modeOfInterview;
	}

	public void setModeOfInterview(String modeOfInterview) {
		this.modeOfInterview = modeOfInterview;
	}

	public LocalDateTime getSeculdedDateAndTime() {
		return seculdedDateAndTime;
	}

	public void setSeculdedDateAndTime(LocalDateTime seculdedDateAndTime) {
		this.seculdedDateAndTime = seculdedDateAndTime;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public StringBuffer getCandidateFeedBack() {
		return candidateFeedBack;
	}

	public void setCandidateFeedBack(StringBuffer candidateFeedBack) {
		this.candidateFeedBack = candidateFeedBack;
	}

	public Integer getInterviewCandidateEvaluationId() {
		return InterviewCandidateEvaluationId;
	}

	public void setInterviewCandidateEvaluationId(Integer interviewCandidateEvaluationId) {
		this.InterviewCandidateEvaluationId = interviewCandidateEvaluationId;
	}
	
	public Boolean getSendAnEmailToPanel() {
		return sendAnEmailToPanel;
	}

	public void setSendAnEmailToPanel(Boolean sendAnEmailToPanel) {
		this.sendAnEmailToPanel = sendAnEmailToPanel;
	}

	public Boolean getSendCalendarInviteToPanel() {
		return sendCalendarInviteToPanel;
	}

	public void setSendCalendarInviteToPanel(Boolean sendCalendarInviteToPanel) {
		this.sendCalendarInviteToPanel = sendCalendarInviteToPanel;
	}

	@Override
	public String toString() {
		return "EvaluationProgress [evaluationProgressId=" + evaluationProgressId + ", interviewerLevel="
				+ interviewerLevel + ", panelName=" + panelName + ", modeOfInterview=" + modeOfInterview
				+ ", seculdedDateAndTime=" + seculdedDateAndTime + ", interviewStatus=" + interviewStatus
				+ ", sendAnEmailToPanel=" + sendAnEmailToPanel + ", sendCalendarInviteToPanel="
				+ sendCalendarInviteToPanel + ", candidateFeedBack=" + candidateFeedBack
				+ ", InterviewCandidateEvaluationId=" + InterviewCandidateEvaluationId + "]";
	}
	
}
