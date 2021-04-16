import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

import java.io.FileNotFoundException;
import java.io.IOException;

public class KaufvertragAusgabe {


    public static void main(String[] args) throws IOException {
        String datei = "csv.pdf";
        PdfWriter writer = new PdfWriter(datei);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        document.setFont(font);
        document.setFontSize(12);
        document.setBold();
        document.setItalic();
        document.setUnderline();
        document.setTextAlignment(TextAlignment.LEFT);
        document.setFontColor(new DeviceRgb(50,100,150));

        Paragraph p1 = new Paragraph("Kaufvertrag");
        p1.add("\n\n");
        p1.add("\tVerkäufer");
        p1.add("Amk");
        document.add(p1);

        Style styleNormal = new Style();
        styleNormal.setFont(PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN));
        styleNormal.setFontSize(12);
        Style styleSpecial = new Style();
        PdfFont fontSpecial = PdfFontFactory.createFont(StandardFonts.COURIER);
        DeviceRgb colorSpecial = new DeviceRgb(255,0,0);
        styleSpecial.setFont(fontSpecial).setFontSize(12).setFontColor(colorSpecial);
        Paragraph p2 = new Paragraph();
        p2.addStyle(styleNormal);
        p2.add(new Text("Jan").addStyle(styleSpecial));
        p2.add(new Text("Hallo\t"));
        p2.add(new Text("dxfcgh").addStyle(styleSpecial));
        document.add(p2);






        document.close();
    }



}

