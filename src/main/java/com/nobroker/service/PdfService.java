package com.nobroker.service;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;
import com.nobroker.entity.User;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {


    public byte[] generatePdfReport(List<User> userList) throws DocumentException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);

        document.open();

        // Add a table with column headers
        PdfPTable table = new PdfPTable(5); // 5 columns
        table.setWidthPercentage(100);

        table.addCell("ID");
        table.addCell("Name");
        table.addCell("Email");
        table.addCell("Mobile");
        table.addCell("Email Verified");

        // Populate the table with user data
        for (User user : userList) {
            table.addCell(user.getId().toString());
            table.addCell(user.getName());
            table.addCell(user.getEmail());
            table.addCell(user.getMobile());
            table.addCell(String.valueOf(user.isEmailVerified()));
        }

        document.add(table);

        document.close();

        return baos.toByteArray();
    }
}
