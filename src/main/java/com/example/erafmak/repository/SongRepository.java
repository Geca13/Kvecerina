package com.example.erafmak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.erafmak.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

}
