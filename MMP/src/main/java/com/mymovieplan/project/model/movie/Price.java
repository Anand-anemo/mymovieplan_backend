package com.mymovieplan.project.model.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Price {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int priceid;
	  private double general;

	  private double silver;

	  private double gold;
	  
	  public Price() {}

	public Price(double general, double silver, double gold) {
		super();
		this.general = general;
		this.silver = silver;
		this.gold = gold;
	}
	  
	  

}
