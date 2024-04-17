package net.codejava.api.upload;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FileUploadController {

	@PostMapping("/uploadFile")
	public ResponseEntity<FileUploadResponse> uploadFile(
			@RequestParam("file") MultipartFile multipartFile,
			@RequestParam("selectedApplication") String selectedApplication,
			@RequestParam("selectedEnvironment")  String selectedEnvironment,
			@RequestParam("selectedServers")  String selectedServers
			
			
			) throws IOException {
		
		System.out.println("selectedApplication:"+selectedApplication +">>selectedEnvironment:"+selectedEnvironment +">>:selectedServers"+selectedServers);
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		long size = multipartFile.getSize();
		
		String fileCode = FileUploadUtil.saveFile(fileName, multipartFile);
		
		FileUploadResponse response = new FileUploadResponse();
		response.setFileName(fileName);
		response.setSize(size);
		response.setDownloadUri("C:\\Users\\91998\\OneDrive\\Desktop\\" + fileCode);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
