


//
//    private List<User> getUserData() {
//        // Implement logic to fetch user data from your database or other source
//        // For demonstration, creating dummy data
//        return List.of(
//                new User(1L, "John Doe", "john@example.com", "123456", "123-456-7890", true),
//                new User(2L, "Jane Doe", "jane@example.com", "654321", "987-654-3210", false)
//        );
//    }
//}
//
package com.nobroker.controller;

import com.nobroker.entity.User;
import com.nobroker.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/csv")
public class CsvController {

    @Autowired
    private CsvService csvService;

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generateCsvReport() {
        List<User> userList = csvService.getUserData(); // Use CsvService to fetch users
        byte[] csvBytes = csvService.generateCsvReport(userList);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDispositionFormData("inline", "DbToCsv.csv");

        return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
    }
}
