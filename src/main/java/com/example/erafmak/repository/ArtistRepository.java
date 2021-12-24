package com.example.erafmak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.erafmak.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
