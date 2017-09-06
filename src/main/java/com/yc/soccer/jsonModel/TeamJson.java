package com.yc.soccer.jsonModel;

import java.util.Arrays;

import com.yc.soccer.bean.Team;

public class TeamJson {
	private String reason;
	private Team[] result;
	private Integer error_code;
	
	
	public TeamJson(String reason, Team[] result, Integer error_code) {
		super();
		this.reason = reason;
		this.result = result;
		this.error_code = error_code;
	}


	public TeamJson() {
		super();
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public Team[] getResult() {
		return result;
	}


	public void setResult(Team[] result) {
		this.result = result;
	}


	public Integer getError_code() {
		return error_code;
	}


	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}


	@Override
	public String toString() {
		return "TeamJson [reason=" + reason + ", result=" + Arrays.toString(result) + ", error_code=" + error_code
				+ "]";
	}
	
	
}
