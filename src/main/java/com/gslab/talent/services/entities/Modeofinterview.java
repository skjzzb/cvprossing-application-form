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
 * The persistent class for the modeofinterview database table.
 * 
 */
@Entity
@Table(name="modeofinterview")
@NamedQuery(name="Modeofinterview.findAll", query="SELECT m FROM Modeofinterview m")
public class Modeofinterview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mode_id", unique=true, nullable=false)
	private long modeId;

	@Column(name="mode_of_communication", length=45)
	private String modeOfCommunication;

	/*
	 * //bi-directional many-to-one association to Evaluationprogress
	 * 
	 * @OneToMany(mappedBy="modeofinterview") private List<Evaluationprogress>
	 * evaluationprogresses;
	 */

	public Modeofinterview() {
	}

	public long getModeId() {
		return this.modeId;
	}

	public void setModeId(long modeId) {
		this.modeId = modeId;
	}

	public String getModeOfCommunication() {
		return this.modeOfCommunication;
	}

	public void setModeOfCommunication(String modeOfCommunication) {
		this.modeOfCommunication = modeOfCommunication;
	}

}