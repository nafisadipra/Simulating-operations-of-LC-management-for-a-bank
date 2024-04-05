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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PDF {
    public static void main(String[] args) throws MalformedURLException {
        try {
            PdfWriter writer = new PdfWriter(new FileOutputStream("Invoice.pdf"));
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
            document.add(new Paragraph("Invoice No: 1234567").setFontSize(8));
            document.add(new Paragraph("\nBill To:"));
            document.add(new Paragraph("Apple").setFontSize(8));
            document.add(new Paragraph("Address: X,Y").setFontSize(8));
            document.add(new Paragraph("Country: USA").setFontSize(8));
            document.add(new Paragraph("\nShip To:"));
            document.add(new Paragraph("Google").setFontSize(8));
            document.add(new Paragraph("Address: X,Y").setFontSize(8));
            document.add(new Paragraph("Country: USA").setFontSize(8));
            document.add(new Paragraph("\nCart:"));

            Table table = new Table(4);
            float pageWidth = pdf.getDefaultPageSize().getWidth();
            float usableWidth = pageWidth - document.getLeftMargin() - document.getRightMargin();
            table.setWidth(usableWidth);

            // table
            table.addCell("Product Name");
            table.addCell("Price");
            table.addCell("Quantity");
            table.addCell("Total Price");
            
            // product
            table.addCell("Product 1");
            table.addCell("100");
            table.addCell("2");
            table.addCell("200");
            document.add(table.setFontSize(8));

            document.add(new Paragraph("\nSubtotal Price: 200$").setItalic().setFontSize(9));
            document.add(new Paragraph("Tax: 15%").setItalic().setFontSize(9));
            document.add(new Paragraph("Total Amount due to tax: 230$").setItalic().setFontSize(9));
            
            document.add(new Paragraph("\nPayment Terms:"));
            document.add(new Paragraph("- 15% tax is applicable on all taxable items/services listed.").setFontSize(8));
            document.add(new Paragraph("- Tax is calculated at a rate of 15% on the subtotal before any discounts are applied.").setFontSize(8));

            Image signatureImage = new Image(ImageDataFactory.create("src/common/iconFiles/signature.png"));
            signatureImage.setWidth(70);
            signatureImage.setHeight(20);
            signatureImage.setHorizontalAlignment(HorizontalAlignment.RIGHT);
            document.add(signatureImage);

            Paragraph signature = new Paragraph("Approved By: " + "____________");
            signature.setFontSize(12);
            signature.setTextAlignment(TextAlignment.RIGHT);
            document.add(signature);

            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
