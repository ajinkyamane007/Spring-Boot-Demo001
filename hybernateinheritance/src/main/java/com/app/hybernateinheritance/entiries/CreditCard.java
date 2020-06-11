package com.app.hybernateinheritance.entiries;

//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity 
@Table(name="card")
//@DiscriminatorValue("cc")
//@PrimaryKeyJoinColumn(name="id")   //Not necessary in latest version
public class CreditCard extends Payment
{

	private String cardnumber;

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}



}
