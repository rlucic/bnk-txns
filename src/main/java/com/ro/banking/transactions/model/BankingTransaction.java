package com.ro.banking.transactions.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;

@ApiModel(description="Banking transaction model", value="BankingTransaction")

@XmlRootElement
@Entity
@Table(name="bankingtransactions")
public class BankingTransaction {

	@Id
	@GeneratedValue
	Long id;
	
	Double value;
	String currency;
	String from_acct;
	String to_acct;
	String from_cust_id;
	String to_cust_id;
	
	public BankingTransaction(){
		super();
	}
	
	public BankingTransaction(String from_acct, String to_acct, Double value, String currency, String from_cust_id,
			String to_cust_id) {
		this();
		this.from_acct = from_acct;
		this.to_acct = to_acct;
		this.value = value;
		this.currency = currency;
		this.from_cust_id = from_cust_id;
		this.to_cust_id = to_cust_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getFrom_acct() {
		return from_acct;
	}
	public void setFrom_acct(String from_acct) {
		this.from_acct = from_acct;
	}
	public String getTo_acct() {
		return to_acct;
	}
	public void setTo_acct(String to_acct) {
		this.to_acct = to_acct;
	}
	public String getFrom_cust_id() {
		return from_cust_id;
	}
	public void setFrom_cust_id(String from_cust_id) {
		this.from_cust_id = from_cust_id;
	}
	public String getTo_cust_id() {
		return to_cust_id;
	}
	public void setTo_cust_id(String to_cust_id) {
		this.to_cust_id = to_cust_id;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", value=" + value + ", currency=" + currency + ", from_acct=" + from_acct
				+ ", to_acct=" + to_acct + ", from_cust_id=" + from_cust_id + ", to_cust_id=" + to_cust_id + "]";
	}
	
	
}
