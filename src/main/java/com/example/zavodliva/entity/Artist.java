package com.example.zavodliva.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
	
	@Id
	private Integer id;
	
	private String fullName;
	
	private String imageUrl;

}
