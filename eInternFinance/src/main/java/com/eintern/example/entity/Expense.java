package com.eintern.example.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Expense")
public class Expense {
	
	

	@Id
	@GeneratedValue
	@Column(name="iD")
	private int iD;
	@Column(name="description")
	private String name;
	
	 
	@Column(name="transDate")
	private Date date;
	
	@Column(name="category")
	private String category;
	
	@Column(name="ammount")
	private Double ammount;

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}

	@Override
	public String toString() {
		return "Expense [iD=" + iD + ", name=" + name + ", date=" + date + ", category=" + category + ", ammount="
				+ ammount + "]";
	}
	

	
	
	

}
