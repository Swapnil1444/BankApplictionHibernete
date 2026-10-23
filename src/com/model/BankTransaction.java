package com.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class BankTransaction {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private TransactionType transactionType;

	    @Column(nullable = false, precision = 15, scale = 2)
	    private BigDecimal amount;

	    private String sourceAccountNumber;
	    private String destinationAccountNumber;

	    private LocalDateTime transactionDate;

	    @Column(length = 300)
	    private String description;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "account_id", nullable = false)
	    private Accountdetails account;

	    public BankTransaction() {
	    }

	    @PrePersist
	    public void setTransactionDate() {
	        if (transactionDate == null) {
	            transactionDate = LocalDateTime.now();
	        }
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public TransactionType getTransactionType() {
			return transactionType;
		}

		public void setTransactionType(TransactionType transactionType) {
			this.transactionType = transactionType;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}

		public String getSourceAccountNumber() {
			return sourceAccountNumber;
		}

		public void setSourceAccountNumber(String sourceAccountNumber) {
			this.sourceAccountNumber = sourceAccountNumber;
		}

		public String getDestinationAccountNumber() {
			return destinationAccountNumber;
		}

		public void setDestinationAccountNumber(String destinationAccountNumber) {
			this.destinationAccountNumber = destinationAccountNumber;
		}

		public LocalDateTime getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(LocalDateTime transactionDate) {
			this.transactionDate = transactionDate;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Accountdetails getAccount() {
			return account;
		}

		public void setAccount(Accountdetails account) {
			this.account = account;
		}
	
		 @Override
		    public String toString() {
		        return "BankTransaction [id=" + id
		                + ", transactionType=" + transactionType
		                + ", amount=" + amount
		                + ", transactionDate=" + transactionDate
		                + ", description=" + description + "]";
		    }

}
