//package com.nobroker.service;
//
//
//import com.opencsv.CSVWriter;
//import com.nobroker.entity.User;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayOutputStream;
//import java.io.OutputStreamWriter;
//import java.util.List;
//
//@Service
//public class CsvService {
//
//    public byte[] generateCsvReport(List<User> userList) {
//        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
//             CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(baos))) {
//
//            // Write CSV header
//            String[] header = {"ID", "Name", "Email", "Password", "Mobile", "Email Verified"};
//            csvWriter.writeNext(header);
//
//            // Write CSV data
//            for (User user : userList) {
//                String[] data = {
//                        String.valueOf(user.getId()),
//                        user.getName(),
//                        user.getEmail(),
//                        user.getPassword(),
//                        user.getMobile(),
//                        String.valueOf(user.isEmailVerified())
//                };
//                csvWriter.writeNext(data);
//            }
//
//            return baos.toByteArray();
//
//        } catch (Exception e) {
//            e.printStackTrace(); // Handle exception appropriately
//            return null;
//        }
//    }
//}
package com.nobroker.service;

import com.opencsv.CSVWriter;
import com.nobroker.entity.User;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

@Service
public class CsvService {

    public byte[] generateCsvReport(List<User> userList) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(baos))) {

            // Write CSV header
            String[] header = {"ID", "Name", "Email", "Password", "Mobile", "Email Verified"};
            csvWriter.writeNext(header);

            // Write CSV data
            for (User user : userList) {
                String[] data = {
                        String.valueOf(user.getId()),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getMobile(),
                        String.valueOf(user.isEmailVerified())
                };
                csvWriter.writeNext(data);
            }

            return baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately
            return null;
        }
    }

    public List<User> getUserData() {
        // Implement logic to fetch user data from your database or other source
        // For demonstration, creating dummy data
        return List.of(
                new User(1L, "John Doe", "john@example.com", "123456", "123-456-7890", true),
                new User(2L, "Jane Doe", "jane@example.com", "654321", "987-654-3210", false)
        );
    }
}
