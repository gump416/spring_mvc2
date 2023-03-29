package ezen.springmvc.fileupload.controller;

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
public class UploadFile { //중복된파일 a.txt라는 이름의 중복된 파일이 있을때 a1.txt 이런식으로 저장
	private String uploadFileName;//중복파일
	private String storeFileName; //실제 a1으로 저장
}
