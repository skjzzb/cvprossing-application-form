package com.gslab.talent.services.service;

import java.util.List;

import com.gslab.talent.services.entities.Isavailableforinterview;

public interface IsAvailableForInterviewService {

	public void createIsAvailableForInterview(Isavailableforinterview Isavailableforinterview);
	public List<Isavailableforinterview> getIsAvailableForInterview();
	public Isavailableforinterview findById(long id);
	public Isavailableforinterview update(Isavailableforinterview Isavailableforinterview, long l);
	public void deleteIsavailableforinterviewById(long id);
	public Isavailableforinterview updatePartially(Isavailableforinterview Isavailableforinterview, long id);
}
