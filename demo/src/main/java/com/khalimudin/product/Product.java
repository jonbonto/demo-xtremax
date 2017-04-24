package com.khalimudin.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity(name="DEMO_PRODUCT")
public class Product {
	
	// "product_demo_seq" is Oracle sequence name.
    @Id	
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROD_DEMO_SEQ")
    @SequenceGenerator(sequenceName = "product_demo_seq", allocationSize = 1, name = "PROD_DEMO_SEQ")
	private long id;
    @NotNull @Length(min = 3,max=100)
    private String name;
    @NotNull @DecimalMin("1000.00")
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

   
}
