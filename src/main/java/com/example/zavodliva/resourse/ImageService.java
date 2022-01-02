package com.example.zavodliva.resourse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.zavodliva.entity.Show;

@Service
public class ImageService {
	
	@Autowired
	ShowService showService;
	
	public void uploadImage(MultipartFile multiPartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multiPartFile.getOriginalFilename());
		
		Path currentPath = Paths.get(".");
		Path absolutePath = currentPath.toAbsolutePath();
		String uploadDir = absolutePath + "/src/main/resources/static/img/";
		Path uploadPath = Paths.get(uploadDir);
		
        try (InputStream inputStream = multiPartFile.getInputStream()) {
			
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			throw new IOException("Something went wrong during image upload, please try again");
		}
	}
	
    public Show updateShowImage(Integer id, MultipartFile multiPartFile) throws IOException {
		
    	Show show = showService.findById(id);
		
		String fileName = StringUtils.cleanPath(multiPartFile.getOriginalFilename());
		show.setImageUrl("/img/" + fileName);
		try {
			uploadImage( multiPartFile);
		} catch (IOException e) {
			throw new IOException("Something went wrong during image upload, please try again");
		}
		return showService.updateShow(show);
	}
	
	public void deleteImage(Show show) {
		String storedImage = show.getImageUrl().substring(show.getImageUrl().lastIndexOf("/"));
		Path currentPath = Paths.get(".");
		Path absolutePath = currentPath.toAbsolutePath();
		
		String uploadDir = absolutePath + "/src/main/resources/static/img/";
		
            File file = new File(uploadDir + storedImage);
            if(file.exists()) {
            	file.delete();
            }    
	}

}
