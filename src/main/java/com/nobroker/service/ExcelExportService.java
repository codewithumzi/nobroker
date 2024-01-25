package com.nobroker.service;

import com.nobroker.entity.User;
import com.nobroker.repository.UserRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {
    @Autowired
    private UserRepository userRepository;


    public byte[] exportUsersToExcel() throws IOException {
        List<User> userList=userRepository.findAll();//getting data from db
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out=new ByteArrayOutputStream()){//create object of xssfworkbook
            Sheet sheet = workbook.createSheet("Users");//creating sheet namely users
            //create header now
            Row headerRow = sheet.createRow(0);//creating header row in excel
            //then creating array of columns
            String[] columns = {"ID", "Name", "Email", "Password", "Mobile", "Email Verified"};
           for(int i = 0; i<columns.length; i++) { //create header in excel file with above column names
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }
                        //now fill data rows
            int rowNum = 1;
        for(User user :userList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
                row.createCell(3).setCellValue(user.getPassword());
                row.createCell(4).setCellValue(user.getMobile());
                row.createCell(5).setCellValue(user.isEmailVerified());
            }

            workbook.write(out);
            return out.toByteArray();

        }

    }
}