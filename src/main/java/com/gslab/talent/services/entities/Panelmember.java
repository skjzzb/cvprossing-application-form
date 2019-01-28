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
 * The persistent class for the panelmembers database table.
 * 
 */
@Entity
@Table(name="panelmembers")
@NamedQuery(name="Panelmember.findAll", query="SELECT p FROM Panelmember p")
public class Panelmember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="panel_member_id", unique=true, nullable=false)
	private int panelMemberId;

	@Column(name="panel_member_email", length=45)
	private String panelMemberEmail;

	@Column(name="panel_member_name", length=45)
	private String panelMemberName;

	/*
	 * //bi-directional many-to-one association to Evaluationprogress
	 * 
	 * @OneToMany(mappedBy="panelmember") private List<Evaluationprogress>
	 * evaluationprogresses;
	 */

	public Panelmember() {
	}

	public int getPanelMemberId() {
		return this.panelMemberId;
	}

	public void setPanelMemberId(int panelMemberId) {
		this.panelMemberId = panelMemberId;
	}

	public String getPanelMemberEmail() {
		return this.panelMemberEmail;
	}

	public void setPanelMemberEmail(String panelMemberEmail) {
		this.panelMemberEmail = panelMemberEmail;
	}

	public String getPanelMemberName() {
		return this.panelMemberName;
	}

	public void setPanelMemberName(String panelMemberName) {
		this.panelMemberName = panelMemberName;
	}

}