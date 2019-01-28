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
 * The persistent class for the evaluationstatus database table.
 * 
 */
@Entity
@Table(name="evaluationstatus")
@NamedQuery(name="Evaluationstatus.findAll", query="SELECT e FROM Evaluationstatus e")
public class Evaluationstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="evaluation_status_id", unique=true, nullable=false)
	private long evaluationStatusId;

	@Column(name="evaluation_status", length=45)
	private String evaluationStatus;

	/*
	 * //bi-directional many-to-one association to Candidate
	 * 
	 * @OneToMany(mappedBy="evaluationstatus") private List<Candidate> candidates;
	 * 
	 * //bi-directional many-to-one association to Evaluationprogress
	 * 
	 * @OneToMany(mappedBy="evaluationstatus") private List<Evaluationprogress>
	 * evaluationprogresses;
	 */

	public Evaluationstatus() {
	}

	public long getEvaluationStatusId() {
		return this.evaluationStatusId;
	}

	public void setEvaluationStatusId(long evaluationStatusId) {
		this.evaluationStatusId = evaluationStatusId;
	}

	public String getEvaluationStatus() {
		return this.evaluationStatus;
	}

	public void setEvaluationStatus(String evaluationStatus) {
		this.evaluationStatus = evaluationStatus;
	}

}