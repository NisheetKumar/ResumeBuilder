package com.onlineResumeBuilderApp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfService {
	public void generatePdf(User user, List<Experience>experienceList,String filepath) throws FileNotFoundException, DocumentException {
		Document document=new Document();
		try {
		PdfWriter .getInstance(document, new FileOutputStream(filepath));
		document.open();
		document.add(new Paragraph("Resume"));
		document.add(new Paragraph("============="));
		document.add(new Paragraph(""));
		
		document.add(new Paragraph("personal information"));
		document.add(new Paragraph("--------------------"));
		 document.add(new Paragraph("Name: " + user.getFirstName() + " " + user.getLastName()));
         document.add(new Paragraph("Email: " + user.getEmail()));
         document.add(new Paragraph("Phone: " + user.getPhone()));
         document.add(new Paragraph("Summary: " + user.getSummary()));
         document.add(new Paragraph(""));

         document.add(new Paragraph("Experience"));
         document.add(new Paragraph("----------"));
         for (Experience exp : experienceList) {
             document.add(new Paragraph("Company: " + exp.getCompany()));
             document.add(new Paragraph("Position: " + exp.getPosition()));
             document.add(new Paragraph("From: " + exp.getStartDate() + " To: " + exp.getEndDate()));
             document.add(new Paragraph("Description: " + exp.getDescription()));
             document.add(new Paragraph(""));
         }

         System.out.println("PDF generated successfully!");
		}
		

      catch (Exception e) {
         System.out.println("An error occurred while generating the PDF.");
         e.printStackTrace();
     } 
		finally {
         document.close();
     }
	}
}
 

