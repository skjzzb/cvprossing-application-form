package com.gslab.talent.services.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the isavailableforinterview database table.
 * 
 */
@Entity
@Table(name="isavailableforinterview")
@NamedQuery(name="Isavailableforinterview.findAll", query="SELECT i FROM Isavailableforinterview i")
public class Isavailableforinterview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="is_available_for_interview_id", unique=true, nullable=false)
	private int isAvailableForInterviewId;

	@Column(name="available_interview_detaile", length=45)
	private String availableInterviewDetaile;

	/*
	 * //bi-directional many-to-one association to Candidate
	 * 
	 * @OneToMany(mappedBy="isavailableforinterview") private List<Candidate>
	 * candidates;
	 */
	
	public int getIsAvailableForInterviewId() {
		return this.isAvailableForInterviewId;
	}

	public void setIsAvailableForInterviewId(int isAvailableForInterviewId) {
		this.isAvailableForInterviewId = isAvailableForInterviewId;
	}

	public String getAvailableInterviewDetaile() {
		return this.availableInterviewDetaile;
	}

	public void setAvailableInterviewDetaile(String availableInterviewDetaile) {
		this.availableInterviewDetaile = availableInterviewDetaile;
	}

}