package com.example.zavodliva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zavodliva.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

	List<Artist> findByOrderByFullNameAsc();

}