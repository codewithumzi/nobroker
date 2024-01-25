package com.nobroker.service;

import com.nobroker.entity.User;
import com.nobroker.repository.UserRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {
    @Autowired
    private UserRepository userRepository;

    public void exportUsersToExcel() {
        List<User> userList = userRepository.findAll(); // getting data from db

        try (Workbook workbook = new XSSFWorkbook()) { // create object of xssfworkbook
            Sheet sheet = workbook.createSheet("Users"); // creating sheet named "Users"

            // create header now
            Row headerRow = sheet.createRow(0); // creating row in Excel

            // create header in Excel file with above column names
            String[] columns = {"ID", "Name", "Email", "Password", "Mobile", "Email Verified"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // now fill data rows
            int rowNum = 1;
            for (User user : userList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
                row.createCell(3).setCellValue(user.getPassword());
                row.createCell(4).setCellValue(user.getMobile());
                row.createCell(5).setCellValue(user.isEmailVerified());
            }

            // save workbook to file
            try (FileOutputStream outputStream = new FileOutputStream("D://manual_path.xlsx")) {//download
                workbook.write(outputStream);//start writing
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
