package ezen.springmvc.fileupload.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileUploadController {

	// application.properties에 설정된 파일 경로
	// @Value("C:/Lecture/projects/spring-mvc/file-upload/")
	@Value("${file.dir}") // @Value는 application.properties에 있는 file.dir 값 읽어옴
	private String location;

	@GetMapping("/upload")
	public String uploadForm() {
		return "upload/form";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("uploader") String uploader,
			                 @RequestParam("uploadfile") MultipartFile uploadfile,
			                 Model model) throws IOException {
		log.info("업로더 = {}", uploader);
		log.info("multipartFile = {}", uploadfile);
		
		
		if (!uploadfile.isEmpty()) {
			String fullPath = location + uploadfile.getOriginalFilename();
			log.info("파일 저장 fullPath = {}", fullPath);
			File uploadDir = new File(fullPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			uploadfile.transferTo(uploadDir);
			model.addAttribute("uploader", uploader);
			model.addAttribute("uploadfile", uploadfile.getOriginalFilename());
		}
		return "upload/upload-result";
	}

}
