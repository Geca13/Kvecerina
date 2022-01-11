package com.example.zavodliva.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {
	
	@Id
	private Integer id;
	
	private String title;
	
	private String imageUrl;
	
	private String audioUrl;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate published;
	
	@ManyToMany
	private List<Song> songs;

}
