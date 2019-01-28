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
 * The persistent class for the interviewerlevel database table.
 * 
 */
@Entity
@Table(name="interviewerlevel")
@NamedQuery(name="Interviewerlevel.findAll", query="SELECT i FROM Interviewerlevel i")
public class Interviewerlevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="interviewer_level_id", unique=true, nullable=false)
	private int interviewerLevelId;

	@Column(length=45)
	private String interviewer_level;

	/*
	 * //bi-directional many-to-one association to Evaluationprogress
	 * 
	 * @OneToMany(mappedBy="interviewerlevel") private List<Evaluationprogress>
	 * evaluationprogresses;
	 */

	public Interviewerlevel() {
	}

	public int getInterviewerLevelId() {
		return this.interviewerLevelId;
	}

	public void setInterviewerLevelId(int interviewerLevelId) {
		this.interviewerLevelId = interviewerLevelId;
	}

	public String getInterviewer_level() {
		return this.interviewer_level;
	}

	public void setInterviewer_level(String interviewer_level) {
		this.interviewer_level = interviewer_level;
	}

}