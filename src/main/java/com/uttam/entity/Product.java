package com.uttam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
	@Id
	@SequenceGenerator(name = "plan_seq", sequenceName = "plan_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "plan_seq", strategy = GenerationType.SEQUENCE)
	private Long pid;

	private String name;
	private Double price;
	private int quantity;

}
