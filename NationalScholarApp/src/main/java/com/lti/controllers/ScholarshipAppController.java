package com.lti.controllers;



import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lti.dto.DocumentsDto;
import com.lti.dto.ScholarshipApplicationDto;
import com.lti.entity.ScholarshipApplication;
import com.lti.service.ScholarshipApplicationService;

@RequestMapping("/scholar-form")
@CrossOrigin("http://localhost:4200/")
@RestController
public class ScholarshipAppController {
	
	
	@Autowired
	private ScholarshipApplicationService scholarService;
	
	@PostMapping
	public ResponseEntity<?> applyForScholarship(@Valid @RequestBody ScholarshipApplicationDto schDto) {
		
		ScholarshipApplication scApp = scholarService.applyForScholarship(schDto);
		if(scApp !=null) {
			URI uri = ServletUriComponentsBuilder
			.fromCurrentRequest().path("/{id}")
			.buildAndExpand(scApp.getScholarshipId())
			.toUri();
			
			return ResponseEntity.created(uri).build();
		}
		return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/upload")
	public String documentUpload(DocumentsDto dDto) {
		return scholarService.uploadDocuments(dDto);
	}
	
	
	
	/*
	 * @GetMapping("/download/{fileName:.+}") public ResponseEntity<Resource>
	 * downloadFile(@PathVariable String fileName) throws FileNotFoundException {
	 * File file = new File(UPLOADED_FOLDER + fileName); InputStreamResource
	 * resource = new InputStreamResource(new FileInputStream(file)); HttpHeaders
	 * headers = new HttpHeaders(); headers.add("Content-Disposition",
	 * String.format("attachment; filename=\"%s\"", file.getName()));
	 * headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	 * headers.add("Pragma", "no-cache"); headers.add("Expires", "0");
	 * 
	 * return ResponseEntity.ok() .headers(headers) .contentLength(file.length())
	 * .contentType(MediaType.parseMediaType("application/octet-stream"))
	 * .body(resource); }
	 */
}
