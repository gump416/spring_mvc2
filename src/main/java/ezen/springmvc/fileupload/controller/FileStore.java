package ezen.springmvc.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

//업로드 된 파일 저장 및 관리
@Component
public class FileStore {

	@Value("${file.dir}")
	private String location;

	public String getFullPath(String filename) {
		return location + filename;
	}

	public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
		List<UploadFile> storeFileResult = new ArrayList<UploadFile>();
		for (MultipartFile multipartFile : multipartFiles) {
			if (!multipartFile.isEmpty()) {
				// 업로드 파일 저장
				UploadFile uploadFile = storeFile(multipartFile);
				storeFileResult.add(uploadFile);
			}
		}
		return storeFileResult;
	}

	public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
		if (multipartFile == null || multipartFile.isEmpty()) {
			return null;
		}
		String originalFilename = multipartFile.getOriginalFilename();
		String storeFileName = createStoreFileName(originalFilename);
		multipartFile.transferTo(new File(getFullPath(storeFileName)));
		/*
		 "transferTo"는 MultipartFile 객체의 내용을 지정된 파일로 전송하는 메소드입니다.
		위 코드에서 "multipartFile"은 업로드된 파일을 나타내는 MultipartFile 객체이며, 
		"storeFileName"은 업로드된 파일을 저장할 파일 이름을 가지고 있는 변수입니다. 
		"getFullPath(storeFileName)"은 파일이 저장될 전체 경로를 반환하는 함수입니다.
		따라서 위 코드는 업로드된 파일인 "multipartFile"의 내용을 "storeFileName" 변수에 저장된 파일 이름과 "getFullPath(storeFileName)" 함수에서 
		반환한 전체 경로를 사용하여 새 파일로 전송합니다. 즉, 업로드된 파일을 저장하는 작업을 수행합니다.
		전송이 완료되면, 새로운 파일에 업로드된 파일의 내용이 저장되며, 해당 파일은 지정된 경로에 생성됩니다.
		*/
		
		return new UploadFile(originalFilename, storeFileName);
	}

	//헬퍼메소드
	private String createStoreFileName(String originalFilename) {
		String ext = extractExt(originalFilename);
		String uuid = UUID.randomUUID().toString(); //UUID는 중복이름일때 유일한 식별자를 반환해줌 a.txt일때 a1.txt이런식으로...
		return originalFilename + "-" + uuid + "." + ext;
	}

	//헬퍼의 헬퍼메소드
	private String extractExt(String originalFilename) {
		int pos = originalFilename.lastIndexOf("."); //"."이 마지막에 찍힌 index를 반환하여, "."뒤에 오는 확장자를 추출할 수 있음.
		return originalFilename.substring(pos + 1); //"."뒤에 이름 반환
	}
}
