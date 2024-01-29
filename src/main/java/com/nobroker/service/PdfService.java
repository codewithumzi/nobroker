package com.nobroker.service;

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

    public byte[] generatePdfReport(List<User> userList) throws DocumentException{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, baos);

            document.open();
            document.add(new Paragraph("User Report"));

            for (User user : userList) {
                document.add(new Paragraph("Name: " + user.getName()));
                document.add(new Paragraph("Email: " + user.getEmail()));
                // Add other user details as needed
                document.add(new Paragraph("\n"));
            }

            document.close();

            return baos.toByteArray();

    }

}

