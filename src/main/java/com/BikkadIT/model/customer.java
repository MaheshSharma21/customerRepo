package com.BikkadIT.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cusid;

	private String cusName;

	private String cusAddress;

	private String cusmail;

	private Double cusSalary;

	private int cusAge;

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAddress() {
		return cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public String getCusmail() {
		return cusmail;
	}

	public void setCusmail(String cusmail) {
		this.cusmail = cusmail;
	}

	public Double getCusSalary() {
		return cusSalary;
	}

	public void setCusSalary(Double cusSalary) {
		this.cusSalary = cusSalary;
	}

	public int getCusAge() {
		return cusAge;
	}

	public void setCusAge(int cusAge) {
		this.cusAge = cusAge;
	}

	@Override
	public String toString() {
		return "customer [cusid=" + cusid + ", cusName=" + cusName + ", cusAddress=" + cusAddress + ", cusmail="
				+ cusmail + ", cusSalary=" + cusSalary + ", cusAge=" + cusAge + "]";
	}

}
