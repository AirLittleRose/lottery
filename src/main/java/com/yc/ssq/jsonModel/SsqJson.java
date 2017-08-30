package com.yc.ssq.jsonModel;

import java.util.List;

public class SsqJson {
	
	private String reason;
	private Integer error_code;
	private List<Ssq> result;	
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getError_code() {
		return error_code;
	}

	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}

	public List<Ssq> getResult() {
		return result;
	}

	public void setResult(List<Ssq> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "SsqJson [reason=" + reason + ", error_code=" + error_code + ", result=" + result + "]";
	}

}
