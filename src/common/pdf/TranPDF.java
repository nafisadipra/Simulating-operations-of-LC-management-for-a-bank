package common.pdf;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import common.reader.Reader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TranPDF {
    public void generate(String location, String serial, String total, String fromEmail, String toEmail){
        try {
            PdfWriter writer = new PdfWriter(new FileOutputStream(location + "/" + serial +".pdf"));
            PdfDocument pdf = new PdfDocument(writer);

            Document document = new Document(pdf);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a, dd/MM/yyyy");
            Paragraph timeAndDate = new Paragraph(now.format(formatter));
            timeAndDate.setFontSize(8);
            document.add(timeAndDate.setTextAlignment(TextAlignment.RIGHT));

            Paragraph header = new Paragraph("Invoice");
            header.setFontSize(50);
            header.setBold();
            header.setTextAlignment(TextAlignment.CENTER);
            document.add(header);

            document.add(new Paragraph("LC Bank"));
            document.add(new Paragraph("House no. 6, Road 18, Block B Mirpur 10 Roundabout, Dhaka 1216").setFontSize(8));
            document.add(new Paragraph("Bangladesh").setFontSize(8));
            document.add(new Paragraph("Invoice No: " + serial).setFontSize(8));

            ArrayList<ArrayList<String>> proFetch1 = (new Reader("Database/User/" + "CLIENT" + "/" + fromEmail, "profile.bin"))
                .splitFile('▓');
            
            ArrayList<ArrayList<String>> proFetch2 = (new Reader("Database/User/" + "MERCHANT" + "/" + toEmail, "profile.bin"))
                .splitFile('▓');
            
            document.add(new Paragraph("\nImporter:"));
            document.add(new Paragraph(proFetch1.get(0).get(0)).setFontSize(8));
            document.add(new Paragraph("Email: " + fromEmail).setFontSize(8));
            document.add(new Paragraph("Phone: " + proFetch1.get(0).get(2)).setFontSize(8));
            document.add(new Paragraph("Company: " + proFetch1.get(0).get(8)).setFontSize(8));
            document.add(new Paragraph("Address: " + proFetch1.get(0).get(3)).setFontSize(8));
            document.add(new Paragraph("Country: " + proFetch1.get(0).get(6)).setFontSize(8));          
            
            document.add(new Paragraph("\nExporter:"));
            document.add(new Paragraph(proFetch2.get(0).get(0)).setFontSize(8));
            document.add(new Paragraph("Email: " + toEmail).setFontSize(8));
            document.add(new Paragraph("Phone: " + proFetch2.get(0).get(2)).setFontSize(8));
            document.add(new Paragraph("Company: " + proFetch2.get(0).get(8)).setFontSize(8));
            document.add(new Paragraph("Address: " + proFetch2.get(0).get(3)).setFontSize(8));
            document.add(new Paragraph("Country: " + proFetch2.get(0).get(6)).setFontSize(8)); 
            
            // table
            document.add(new Paragraph("\nCart:"));
            Table table = new Table(4);
            float pageWidth = pdf.getDefaultPageSize().getWidth();
            float usableWidth = pageWidth - document.getLeftMargin() - document.getRightMargin();
            
            table.setWidth(usableWidth);
            table.addCell("Product Name");
            table.addCell("Price");
            table.addCell("Quantity");
            table.addCell("Total Price");
            
            // product
            int j  = 0;
            for (ArrayList<String> X: (new Reader("Database/Official/PI", serial+".bin")).splitFile('▓')) {
                if (j > 4) {
                    table.addCell(X.get(0));
                    table.addCell(X.get(1));
                    table.addCell(X.get(2));
                    table.addCell("$" + X.get(3));
                }
                j += 1;
            }
            document.add(table.setFontSize(8));

            document.add(new Paragraph("\nSubtotal Price: " + total + "$").setItalic().setFontSize(9));
            document.add(new Paragraph("Tax: 15%").setItalic().setFontSize(9));
            document.add(new Paragraph("Total Amount due to tax: " + ((long) Double.parseDouble(total) + (long) (Double.parseDouble(total)*15/100)) + "$").setItalic().setFontSize(9));
            
            document.add(new Paragraph("\nPayment Terms:"));
            document.add(new Paragraph("- 15% tax is applicable on all taxable items/services listed.").setFontSize(8));
            document.add(new Paragraph("- Tax is calculated at a rate of 15% on the subtotal before any discounts are applied.").setFontSize(8));
            
            try {
                Image signatureImage = new Image(ImageDataFactory.create("src/common/iconFiles/signature.png"));
                signatureImage.setWidth(70);
                signatureImage.setHeight(20);
                signatureImage.setHorizontalAlignment(HorizontalAlignment.RIGHT);
                document.add(signatureImage);

                Paragraph signature = new Paragraph("Approved By: " + "____________");
                signature.setFontSize(12);
                signature.setTextAlignment(TextAlignment.RIGHT);
                document.add(signature);
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }

            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
