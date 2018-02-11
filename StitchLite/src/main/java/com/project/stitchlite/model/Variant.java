package com.project.stitchlite.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="variant")
//@SQLInsert( sql="INSERT INTO variant(size, color, sku, quantity, price, date_created,"
//		+ "date_updated) VALUES (?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE size=VALUES(size),"
//		+ "color=VALUES(color), sku=VALUES(sku), quantity=VALUES(quantity), price=VALUES(price),"
//		+ "date_created=VALUES(dateCreated), date_updated=VALUES(dateUpdated)")
public class Variant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	
	private String size;
	private String color;
	
//	@Column(unique=true)
	private String sku;
	private Integer quantity;
	
	private Double price;
	
	private Date dateCreated;
	private Date dateUpdated;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
}
