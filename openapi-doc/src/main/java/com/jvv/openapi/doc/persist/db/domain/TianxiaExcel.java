/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2016年3月21日 下午2:11:00 创建
 */
package com.jvv.openapi.doc.persist.db.domain;

/**
 *
 *
 * @author zhike@jinvovo.com
 * @data 2016年3月21日
 */
public class TianxiaExcel {
	private String oneDate;
	
	private String oneMoney;
	
	private String twoDate;
	
	private String twoMoney;
	
	private String threeDate;
	
	private String threeMoney;
	
	private String fourDate;
	
	private String fourMoney;
	
	private String fiveDate;
	
	private String fiveMoney;
	
	private String sixDate;
	
	private String sixMoney;
	
	public String getOneDate() {
		return this.oneDate;
	}
	
	public void setOneDate(String oneDate) {
		this.oneDate = oneDate;
	}
	
	public String getOneMoney() {
		return this.oneMoney;
	}
	
	public void setOneMoney(String oneMoney) {
		this.oneMoney = oneMoney;
	}
	
	public String getTwoDate() {
		return this.twoDate;
	}
	
	public void setTwoDate(String twoDate) {
		this.twoDate = twoDate;
	}
	
	public String getTwoMoney() {
		return this.twoMoney;
	}
	
	public void setTwoMoney(String twoMoney) {
		this.twoMoney = twoMoney;
	}
	
	public String getThreeDate() {
		return this.threeDate;
	}
	
	public void setThreeDate(String threeDate) {
		this.threeDate = threeDate;
	}
	
	public String getThreeMoney() {
		return this.threeMoney;
	}
	
	public void setThreeMoney(String threeMoney) {
		this.threeMoney = threeMoney;
	}
	
	public String getFourDate() {
		return this.fourDate;
	}
	
	public void setFourDate(String fourDate) {
		this.fourDate = fourDate;
	}
	
	public String getFourMoney() {
		return this.fourMoney;
	}
	
	public void setFourMoney(String fourMoney) {
		this.fourMoney = fourMoney;
	}
	
	public String getFiveDate() {
		return this.fiveDate;
	}
	
	public void setFiveDate(String fiveDate) {
		this.fiveDate = fiveDate;
	}
	
	public String getFiveMoney() {
		return this.fiveMoney;
	}
	
	public void setFiveMoney(String fiveMoney) {
		this.fiveMoney = fiveMoney;
	}
	
	public String getSixDate() {
		return this.sixDate;
	}
	
	public void setSixDate(String sixDate) {
		this.sixDate = sixDate;
	}
	
	public String getSixMoney() {
		return this.sixMoney;
	}
	
	public void setSixMoney(String sixMoney) {
		this.sixMoney = sixMoney;
	}

	/**
	 * @return
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return "TianxiaExcel [oneDate=" + oneDate + ", oneMoney=" + oneMoney + ", twoDate=" + twoDate + ", twoMoney="
				+ twoMoney + ", threeDate=" + threeDate + ", threeMoney=" + threeMoney + ", fourDate=" + fourDate
				+ ", fourMoney=" + fourMoney + ", fiveDate=" + fiveDate + ", fiveMoney=" + fiveMoney + ", sixDate="
				+ sixDate + ", sixMoney=" + sixMoney + "]";
	}

	/**
	 * @return
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fiveDate == null) ? 0 : fiveDate.hashCode());
		result = prime * result + ((fiveMoney == null) ? 0 : fiveMoney.hashCode());
		result = prime * result + ((fourDate == null) ? 0 : fourDate.hashCode());
		result = prime * result + ((fourMoney == null) ? 0 : fourMoney.hashCode());
		result = prime * result + ((oneDate == null) ? 0 : oneDate.hashCode());
		result = prime * result + ((oneMoney == null) ? 0 : oneMoney.hashCode());
		result = prime * result + ((sixDate == null) ? 0 : sixDate.hashCode());
		result = prime * result + ((sixMoney == null) ? 0 : sixMoney.hashCode());
		result = prime * result + ((threeDate == null) ? 0 : threeDate.hashCode());
		result = prime * result + ((threeMoney == null) ? 0 : threeMoney.hashCode());
		result = prime * result + ((twoDate == null) ? 0 : twoDate.hashCode());
		result = prime * result + ((twoMoney == null) ? 0 : twoMoney.hashCode());
		return result;
	}

	/**
	 * @param obj
	 * @return
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TianxiaExcel other = (TianxiaExcel) obj;
		if (fiveDate == null) {
			if (other.fiveDate != null)
				return false;
		} else if (!fiveDate.equals(other.fiveDate))
			return false;
		if (fiveMoney == null) {
			if (other.fiveMoney != null)
				return false;
		} else if (!fiveMoney.equals(other.fiveMoney))
			return false;
		if (fourDate == null) {
			if (other.fourDate != null)
				return false;
		} else if (!fourDate.equals(other.fourDate))
			return false;
		if (fourMoney == null) {
			if (other.fourMoney != null)
				return false;
		} else if (!fourMoney.equals(other.fourMoney))
			return false;
		if (oneDate == null) {
			if (other.oneDate != null)
				return false;
		} else if (!oneDate.equals(other.oneDate))
			return false;
		if (oneMoney == null) {
			if (other.oneMoney != null)
				return false;
		} else if (!oneMoney.equals(other.oneMoney))
			return false;
		if (sixDate == null) {
			if (other.sixDate != null)
				return false;
		} else if (!sixDate.equals(other.sixDate))
			return false;
		if (sixMoney == null) {
			if (other.sixMoney != null)
				return false;
		} else if (!sixMoney.equals(other.sixMoney))
			return false;
		if (threeDate == null) {
			if (other.threeDate != null)
				return false;
		} else if (!threeDate.equals(other.threeDate))
			return false;
		if (threeMoney == null) {
			if (other.threeMoney != null)
				return false;
		} else if (!threeMoney.equals(other.threeMoney))
			return false;
		if (twoDate == null) {
			if (other.twoDate != null)
				return false;
		} else if (!twoDate.equals(other.twoDate))
			return false;
		if (twoMoney == null) {
			if (other.twoMoney != null)
				return false;
		} else if (!twoMoney.equals(other.twoMoney))
			return false;
		return true;
	}
	
	
}
