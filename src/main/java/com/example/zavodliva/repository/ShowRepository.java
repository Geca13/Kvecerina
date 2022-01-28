package com.example.zavodliva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zavodliva.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

	Show findTopByOrderByIdDesc();

	List<Show> findAllByOrderByPublishedDesc();

	Show findTopByOrderByPublishedDesc();


	


}
