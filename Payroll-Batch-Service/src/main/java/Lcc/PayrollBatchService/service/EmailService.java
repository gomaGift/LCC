package Lcc.PayrollBatchService.service;

import jakarta.activation.DataSource;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    public void sendMail(byte[] bytes, String email, String fullName){
        try {


            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject("Employee payroll");
            helper.setTo("giftian.kg@gmail.com");
            helper.setText("Please find the attached employee payroll.");

            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            helper.addAttachment("Payroll for "+ fullName, dataSource);
            mailSender.send(message);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }
    }
    
}
