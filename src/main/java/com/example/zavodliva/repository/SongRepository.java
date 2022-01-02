package com.example.zavodliva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zavodliva.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

}
