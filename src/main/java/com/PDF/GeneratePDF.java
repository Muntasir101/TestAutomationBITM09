package com.PDF;

import com.Base.TestBase;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/*
Capturing Image and Create PDF with this Image
 */
public class GeneratePDF extends TestBase {
    public static void main(String[] args) throws DocumentException, IOException {
        launch_Chrome();
        openURL("https://bbc.com");
        smallWait();
        createPdf();
        smallWait();
        close_Chrome();
    }
    public static void createPdf() throws IOException, DocumentException {
        //Take Screenshot as BYTES
        byte[] input=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        Document doc=new Document();
        String output="./src/main/PdfFiles/NewPDF.pdf";
        FileOutputStream fs=new FileOutputStream(output);
        PdfWriter write=PdfWriter.getInstance(doc,fs);
        write.open();
        doc.open();
        Image img= Image.getInstance(input);
        img.scaleToFit(PageSize.A4.getWidth()/2,PageSize.A4.getHeight()/2);
        doc.add(img);
        doc.close();
        write.close();
    }
}
