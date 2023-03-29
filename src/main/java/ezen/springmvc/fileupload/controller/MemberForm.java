package ezen.springmvc.fileupload.controller;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberForm {
	private String uploader;
	private String description;
	private MultipartFile uploadfile;
	private List<MultipartFile> uploadfiles;
}










