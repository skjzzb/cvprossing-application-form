package com.gslab.talent.services.model;

public class RecordCount {

	private String parameter;
	private Long count;
	
	public RecordCount(String parameter, Long count) {
		super();
		this.parameter = parameter;
		this.count = count;
	}
	
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
}
