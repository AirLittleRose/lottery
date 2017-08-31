package com.yc.soccer.jsonModel;

import java.util.Arrays;

import com.yc.soccer.bean.Game;

public class GameJson {
	private String reason;
	private Game[] result;
	private Integer error_code;
	
	public GameJson(String reason, Game[] result, Integer error_code) {
		super();
		this.reason = reason;
		this.result = result;
		this.error_code = error_code;
	}
	
	public GameJson() {
		super();
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Game[] getResult() {
		return result;
	}

	public void setResult(Game[] result) {
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
		return "GameJson [reason=" + reason + ", result=" + Arrays.toString(result) + ", error_code=" + error_code
				+ "]";
	}
	
}
