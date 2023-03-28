package com.tcs.controller;

import java.awt.PageAttributes.MediaType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.tcs.entity.Emp;
import com.tcs.repositary.EmpRepo;
import com.tcs.service.DatabasePDFService;

@Controller
public class ExportPdfController {
	@Autowired
	private EmpRepo empRepo;

	
	@GetMapping(value="/empController" , produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReport() throws IOException {
		List<Emp> emp = (List<Emp>) empRepo.findAll();
		ByteArrayInputStream bis = DatabasePDFService.playerPDFReport(emp);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=playersf.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));

	}

}
