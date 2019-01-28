package com.gslab.talent.services.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the candidateprofiles database table.
 * 
 */
@Entity
@Table(name="candidateprofiles")
@NamedQuery(name="CandidateProfile.findAll", query="SELECT c FROM CandidateProfile c")
public class CandidateProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	public CandidateProfile(String createUser, String fileDownloadURL, String fileName, long fileSize, String fileType,
			String isMLProcessed) {
		super();
		this.createUser = createUser;
		this.fileDownloadURL = fileDownloadURL;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.isMLProcessed = isMLProcessed;
	}

	@Id
	@TableGenerator(name="TABLE_GEN",table="T_GENERATOR", pkColumnName = "IDS", pkColumnValue = "CANDIDATEPROFILEID.PROFILE_ID", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GEN")
	@Column(name= "profileid", unique=true, nullable=false)
	private int profileId;

	@Basic(optional = false)
	@Column(name = "create_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name="create_user", length=45)
	private String createUser;

	@Column(name="filedownloadurl", nullable=false, length=250)
	private String fileDownloadURL;

	@Column(name="filename", nullable=false, length=45)
	private String fileName;

	@Column(name="filesize")
	private long fileSize;

	@Column(name="filetype",length=20)
	private String fileType;

	@Column(name="ismlprocessed",nullable=false, length=1)
	private String isMLProcessed;

	public CandidateProfile() {
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

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getFileDownloadURL() {
		return fileDownloadURL;
	}

	public void setFileDownloadURL(String fileDownloadURL) {
		this.fileDownloadURL = fileDownloadURL;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getIsMLProcessed() {
		return isMLProcessed;
	}

	public void setIsMLProcessed(String isMLProcessed) {
		this.isMLProcessed = isMLProcessed;
	}

	

}