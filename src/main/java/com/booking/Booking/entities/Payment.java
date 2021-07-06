package com.booking.Booking.entities;

import java.math.*;
import java.util.Date;

import javax.persistence.*;
import com.booking.Booking.enums.Payment_Method;
import com.booking.Booking.enums.Payment_Status;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Payment {
	
	@Id
	@Column(name = "PaymentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long PaymentId;
	
	// Payment Amount
	@Column(name = "Amount")
	private BigDecimal Amount;
	
	// Payment TimeStamp
	@Column(name = "Timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date Timestamp;
	
	// Payment Third Party Transaction Id
	@Column(name = "ThirdPartyTransactionId")
	private Integer ThirdPartyTransactionId;
	
	// Payment Status (NA, InProgess, Pending, Completed, Failed)
	@Column(name = "PaymentStatus")
	@Enumerated(EnumType.STRING)
	private Payment_Status PaymentStatus;
	
	// Payment Method (NetBanking, UPI, CarditCard, DabitCard)
	@Column(name = "PaymentMethod")
	@Enumerated(EnumType.STRING)
	private Payment_Method PaymentMethod;
	
	
	// One to one relations between Booking and Payment (One booking have one payment)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BookingId")
	private Booking BookingId;


	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Payment(long paymentId, BigDecimal amount, Date timestamp, Integer thirdPartyTransactionId,
			Payment_Status paymentStatus, Payment_Method paymentMethod, Booking bookingId) {
		super();
		PaymentId = paymentId;
		Amount = amount;
		Timestamp = timestamp;
		ThirdPartyTransactionId = thirdPartyTransactionId;
		PaymentStatus = paymentStatus;
		PaymentMethod = paymentMethod;
		BookingId = bookingId;
	}


	public long getPaymentId() {
		return PaymentId;
	}


	public void setPaymentId(long paymentId) {
		PaymentId = paymentId;
	}


	public BigDecimal getAmount() {
		return Amount;
	}


	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}


	public Date getTimestamp() {
		return Timestamp;
	}


	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}


	public Integer getThirdPartyTransactionId() {
		return ThirdPartyTransactionId;
	}


	public void setThirdPartyTransactionId(Integer thirdPartyTransactionId) {
		ThirdPartyTransactionId = thirdPartyTransactionId;
	}


	public Payment_Status getPaymentStatus() {
		return PaymentStatus;
	}


	public void setPaymentStatus(Payment_Status paymentStatus) {
		PaymentStatus = paymentStatus;
	}


	public Payment_Method getPaymentMethod() {
		return PaymentMethod;
	}


	public void setPaymentMethod(Payment_Method paymentMethod) {
		PaymentMethod = paymentMethod;
	}


	public Booking getBookingId() {
		return BookingId;
	}


	public void setBookingId(Booking bookingId) {
		BookingId = bookingId;
	}


	@Override
	public String toString() {
		return "Payment [PaymentId=" + PaymentId + ", Amount=" + Amount + ", Timestamp=" + Timestamp
				+ ", ThirdPartyTransactionId=" + ThirdPartyTransactionId + ", PaymentStatus=" + PaymentStatus
				+ ", PaymentMethod=" + PaymentMethod + ", BookingId=" + BookingId + "]";
	}
	
	
	// 
	

}
