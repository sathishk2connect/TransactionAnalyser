package com.transactionanalyser.entities;

import java.io.Serializable;
import java.util.Date;

public class Transaction {
    private String id;
    private Date transactionDate;
    private Double amount;
    private String merchant;
    private String type;
    private String relatedTransaction;

    public Transaction() {
        //default constructor
    }

    public Transaction(String id, Date transactionDate, Double amount, String merchant, String type, String relatedTransaction) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.merchant = merchant;
        this.type = type;
        this.relatedTransaction = relatedTransaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelatedTransaction() {
        return relatedTransaction;
    }

    public void setRelatedTransaction(String relatedTransaction) {
        this.relatedTransaction = relatedTransaction;
    }
}
