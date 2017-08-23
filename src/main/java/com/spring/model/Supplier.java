package com.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Supplier {
	
	@Id
	@GeneratedValue
	@Column(name="supplier_id")
	private int id;
	private String supplierName;
	private String supplierAddress;

	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "supplier", cascade = CascadeType.ALL)
	 private Set<Product> products = new HashSet<Product>();
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	

}