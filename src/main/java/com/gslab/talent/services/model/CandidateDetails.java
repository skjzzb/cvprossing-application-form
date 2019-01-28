package com.gslab.talent.services.model;

import java.io.File;

public class CandidateDetails {

	//Auto Generated
	private Integer candidateId;
	
	// Need validation
	private String position;

	// Need validation
	private String candidateName;

	// Need validation for number and max length
	private Integer contactNumber;
	private String emailId;
	private Integer yearsOfExperience;
	private String currentCompany;
	private String technologyStack;
	private Boolean isAvailableForInterview;
	private File candidateProfile;
	
	public CandidateDetails(Integer candidateId, String position, String candidateName, Integer contactNumber,
			String emailId, Integer yearsOfExperience, String currentCompany, String technologyStack,
			Boolean isAvailableForInterview, File candidateProfile) {
		super();
		this.candidateId = candidateId;
		this.position = position;
		this.candidateName = candidateName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.yearsOfExperience = yearsOfExperience;
		this.currentCompany = currentCompany;
		this.technologyStack = technologyStack;
		this.isAvailableForInterview = isAvailableForInterview;
		this.candidateProfile = candidateProfile;
	}
	public Integer getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public Integer getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getCurrentCompany() {
		return currentCompany;
	}
	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}
	public String getTechnologyStack() {
		return technologyStack;
	}
	public void setTechnologyStack(String technologyStack) {
		this.technologyStack = technologyStack;
	}
	public Boolean getIsAvailableForInterview() {
		return isAvailableForInterview;
	}
	public void setIsAvailableForInterview(Boolean isAvailableForInterview) {
		this.isAvailableForInterview = isAvailableForInterview;
	}
	public File getcandidateProfile() {
		return candidateProfile;
	}
	public void setcandidateProfile(File candidateProfile) {
		this.candidateProfile = candidateProfile;
	}
	
	@Override
	public String toString() {
		return "CandidateDetails [candidateId=" + candidateId + ", position=" + position + ", candidateName="
				+ candidateName + ", contactNumber=" + contactNumber + ", emailId=" + emailId + ", yearsOfExperience="
				+ yearsOfExperience + ", currentCompany=" + currentCompany + ", technologyStack=" + technologyStack
				+ ", isAvailableForInterview=" + isAvailableForInterview + ", candidateProfile=" + candidateProfile + "]";
	}
	
	
}
