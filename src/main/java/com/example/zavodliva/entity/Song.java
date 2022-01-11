package com.example.zavodliva.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
	
	@Id
	private Integer id;
	
	private String name;
	
	private String releaseYear;
	
	@ManyToMany
	private List<Artist> artists;

}
