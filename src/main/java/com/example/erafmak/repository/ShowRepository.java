package com.example.erafmak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.erafmak.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

	Show findTopByOrderByIdDesc();

	


}
