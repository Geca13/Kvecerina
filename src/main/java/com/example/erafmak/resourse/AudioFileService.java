package com.example.erafmak.resourse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AudioFileService {
	
	public void uploadAudio(MultipartFile multiPartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multiPartFile.getOriginalFilename());
		
		Path currentPath = Paths.get(".");
		Path absolutePath = currentPath.toAbsolutePath();
		String uploadDir = absolutePath + "/src/main/resources/static/audios/";
		Path uploadPath = Paths.get(uploadDir);
		
        try (InputStream inputStream = multiPartFile.getInputStream()) {
			
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			throw new IOException("Something went wrong during upload, please try again");
		}
	}
	

}
