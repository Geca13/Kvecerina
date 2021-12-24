package com.example.erafmak.resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.erafmak.repository.SongRepository;

@Service
public class SongService {
	
	@Autowired
	SongRepository songRepository;

}
