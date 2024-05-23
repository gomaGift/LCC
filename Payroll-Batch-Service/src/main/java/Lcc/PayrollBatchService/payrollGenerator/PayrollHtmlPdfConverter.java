package Lcc.PayrollBatchService.payrollGenerator;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;
import jakarta.activation.DataSource;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
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
@RequiredArgsConstructor
public class PayrollHtmlPdfConverter {

    private final JavaMailSender mailSender;
    public void htmlToPdf(String processedHtml, String empFullname) {
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


//            byte[] pdfBytes = byteArrayOutputStream.toByteArray();
//            sendMail(pdfBytes);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    private void sendMail(byte[] bytes){
        try {

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject("Employee payroll");
            helper.setFrom("gomagiftk01@gmail.com");
            helper.setTo("giftian.kg@gmail.com");
            helper.setText("Please find the attached employee payroll.");

            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            helper.addAttachment("Employee Payroll", dataSource);
            mailSender.send(message);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }
    }

    private String formatCurrentDate(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("MMMM yyy");
        return formattedDate.format(localDate);

    }
}