package com.example.zavodliva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.zavodliva.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

	List<Artist> findByOrderByFullNameAsc();

	@Query("SELECT a FROM Artist a WHERE CONCAT(a.id, ' ', a.fullName) LIKE %?1%")
	@Transactional(readOnly = true)
	List<Artist> findBySearch(String search);
	
}
