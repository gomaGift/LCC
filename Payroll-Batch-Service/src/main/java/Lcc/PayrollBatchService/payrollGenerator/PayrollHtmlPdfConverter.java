package Lcc.PayrollBatchService.payrollGenerator;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;
import jakarta.activation.DataSource;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;

@Service
public class PayrollHtmlPdfConverter {

    @Autowired
    private  JavaMailSender mailSender;
    public byte[] htmlToPdf(String processedHtml, String empFullname) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            DefaultFontProvider fontProvider = new DefaultFontProvider(true, true, false);
            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setFontProvider(fontProvider);
            HtmlConverter.convertToPdf(processedHtml, pdfWriter, converterProperties);

            String filePath = "C:\\Users\\Goma\\Desktop\\LCC\\Payroll-Batch-Service\\";
            // Write the byte array to a file
            File outputFile = new File( filePath+ "payslipfor "+ empFullname +" "+ formatCurrentDate()+ ".pdf");

            IOUtils.write(byteArrayOutputStream.toByteArray(), new FileOutputStream(outputFile));

            return byteArrayOutputStream.toByteArray();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }



    private String formatCurrentDate(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("MMMM-yyy");
        return formattedDate.format(localDate);

    }


}