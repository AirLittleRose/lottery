package com.yc.ssq.jsonModel;

import java.io.Serializable;

public class Ssq implements Serializable{

	private static final long serialVersionUID = 6320856736440455015L;
	private String LotteryDate;
	private String LotteryQh;
	private String LotteryNumber;
	private String LotterySales;
		
	public String getLotteryDate() {
		return LotteryDate;
	}

	public void setLotteryDate(String lotteryDate) {
		LotteryDate = lotteryDate;
	}

	public String getLotteryQh() {
		return LotteryQh;
	}

	public void setLotteryQh(String lotteryQh) {
		LotteryQh = lotteryQh;
	}

	public String getLotteryNumber() {
		return LotteryNumber;
	}

	public void setLotteryNumber(String lotteryNumber) {
		LotteryNumber = lotteryNumber;
	}

	public String getLotterySales() {
		return LotterySales;
	}

	public void setLotterySales(String lotterySales) {
		LotterySales = lotterySales;
	}

	@Override
	public String toString() {
		return "Ssq [LotteryDate=" + LotteryDate + ", LotteryQh=" + LotteryQh + ", LotteryNumber=" + LotteryNumber
				+ ", LotterySales=" + LotterySales + "]";
	}
}
