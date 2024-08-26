package com.onlineResumeBuilderApp;

import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.text.DocumentException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        ResumeService resumeService = new ResumeService();
        User user = resumeService.getUserInfo();
        List<Experience> experiences = resumeService.getExperience();
        PdfService  pdfService=new PdfService();
        String filePath="//C://Users//nishe//OneDrive//Desktop//ResumeByProject.pdf";
        pdfService.generatePdf(user, experiences, filePath);
    }
}
