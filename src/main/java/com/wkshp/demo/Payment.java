package com.wkshp.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name="Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    private String name;
    private Double amount;
    
    public Payment() {}

    public Payment(String name, Double amount) {
        this.name = name;
        this.amount = amount;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
    }
    
    public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
    }

    @Override
    public String toString() {
      return ToStringBuilder .reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}