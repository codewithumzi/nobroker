package com.nobroker.controller;


import com.itextpdf.text.DocumentException;
import com.nobroker.entity.User;
import com.nobroker.repository.UserRepository;

import com.nobroker.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pdf")
//http://localhost:8080/pdf/generate

//IF WE NEED IN TABULUR FORM jUST WRITE"GENERATE DATA IN PDF TABLE"
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generatePdfReport() {
      try {
          List<User> userList = userRepository.findAll();

        byte[] pdfBytes = pdfService.generatePdfReport(userList);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "Tabular format.pdf");
        return ResponseEntity.ok().headers(headers).body(pdfBytes);
      }catch (DocumentException e) {

          return ResponseEntity.status(500).build();
      }
    }
}

