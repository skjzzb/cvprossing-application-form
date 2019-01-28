package com.gslab.talent.services.model;

import java.util.Map;

public class InterviewEvaluation {
	
	// Auto Generated GSInterview-
	private Integer id;
	private String profileStatus; // Submitted, ShortListed-Yes, Level-1-Reject, Level-2-Reject, Level-3-Reject
	private CandidateDetails candidateDetails;
	private Map<String,EvaluationProgress> evaluationProgress;
	
	public InterviewEvaluation(Integer id, String profileStatus, CandidateDetails candidateDetails,
			Map<String, EvaluationProgress> evaluationProgress) {
		super();
		this.id = id;
		this.profileStatus = profileStatus;
		this.candidateDetails = candidateDetails;
		this.evaluationProgress = evaluationProgress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfileStatus() {
		return profileStatus;
	}

	public void setProfileStatus(String profileStatus) {
		this.profileStatus = profileStatus;
	}

	public CandidateDetails getCandidateDetails() {
		return candidateDetails;
	}

	public void setCandidateDetails(CandidateDetails candidateDetails) {
		this.candidateDetails = candidateDetails;
	}

	public Map<String, EvaluationProgress> getEvaluationProgress() {
		return evaluationProgress;
	}

	public void setEvaluationProgress(Map<String, EvaluationProgress> evaluationProgress) {
		this.evaluationProgress = evaluationProgress;
	}

	@Override
	public String toString() {
		return "InterviewEvaluation [id=" + id + ", profileStatus=" + profileStatus + ", candidateDetails="
				+ candidateDetails + ", evaluationProgress=" + evaluationProgress + "]";
	}

	
}
