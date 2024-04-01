package Lcc.PayrollBatchService.PayrollGenerator;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;
import jakarta.activation.DataSource;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;


import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;


@Service
@RequiredArgsConstructor
public class PayrollPDfGenerator {

    private final JavaMailSender mailSender;
    public void htmlToPdf(String processedHtml) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {

            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);

            DefaultFontProvider fontProvider = new DefaultFontProvider(true, true, false);
            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setFontProvider(fontProvider);
            HtmlConverter.convertToPdf(processedHtml, pdfWriter, converterProperties);

            byte[] pdfBytes = byteArrayOutputStream.toByteArray();

            try {

                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setSubject("Employee payroll");
                helper.setFrom("gomagiftk01@gmail.com");
                helper.setTo("giftian.kg@gmail.com");
                helper.setText("Please find the attached PDF document.");

                DataSource dataSource = new ByteArrayDataSource(pdfBytes, "application.pdf");
                helper.addAttachment("Employee Payroll", dataSource);
                mailSender.send(message);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                throw new RuntimeException(exception.getMessage());
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
}