package com.mymovieplan.project.model.movie;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Payment {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int payid;
	  

	    private double amount;

	    @Column(name = "payment_date")
	    @Temporal(TemporalType.DATE)
	    private Date paymentDate;

	    @Column(name = "card_number", length = 20)
	    private String cardNumber;

	    @Column(name = "card_expiry_month", length = 5)
	    private String cardExpiryMonth;

	    @Column(name = "card_expiry_year", length = 5)
	    private String cardExpiryYear;

	    @Column(name = "card_cvv", length = 5)
	    private String cardCVV;
	    
	    public Payment() {}

		public Payment(int payid, double amount, Date paymentDate, String cardNumber, String cardExpiryMonth,
				String cardExpiryYear, String cardCVV) {
			super();
			this.payid = payid;
			this.amount = amount;
			this.paymentDate = paymentDate;
			this.cardNumber = cardNumber;
			this.cardExpiryMonth = cardExpiryMonth;
			this.cardExpiryYear = cardExpiryYear;
			this.cardCVV = cardCVV;
		}

		public int getPayid() {
			return payid;
		}

		public void setPayid(int payid) {
			this.payid = payid;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public Date getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
		}

		public String getCardNumber() {
			return cardNumber;
		}

		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}

		public String getCardExpiryMonth() {
			return cardExpiryMonth;
		}

		public void setCardExpiryMonth(String cardExpiryMonth) {
			this.cardExpiryMonth = cardExpiryMonth;
		}

		public String getCardExpiryYear() {
			return cardExpiryYear;
		}

		public void setCardExpiryYear(String cardExpiryYear) {
			this.cardExpiryYear = cardExpiryYear;
		}

		public String getCardCVV() {
			return cardCVV;
		}

		public void setCardCVV(String cardCVV) {
			this.cardCVV = cardCVV;
		}
	    
	    
	  

}
