package com.transactionanalyser.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Transaction {
    private String id;
    private Date transactionDate;
    private Double amount;
    private String merchant;
    private String type;
    private String relatedTransaction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(merchant, that.merchant) &&
                Objects.equals(type, that.type) &&
                Objects.equals(relatedTransaction, that.relatedTransaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionDate, amount, merchant, type, relatedTransaction);
    }

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
