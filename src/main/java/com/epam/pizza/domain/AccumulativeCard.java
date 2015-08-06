package com.epam.pizza.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCUMULATIVE_CARD")
public class AccumulativeCard {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ACCUMULATIVE_CARD_ID")
	private Integer id;
	@ManyToOne
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	private Double accumulated;
	
	public AccumulativeCard() {
		accumulated = 0D;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Double getAccumulated() {
		return accumulated;
	}

	public void setAccumulated(Double accumulated) {
		this.accumulated = accumulated;
	}

	@Override
	public String toString() {
		return "\nAccumulativeCard [id=" + id + ", address=" + address
				+ ", accumulated=" + accumulated + "]";
	}
}
