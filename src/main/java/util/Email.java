package util;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;

import java.util.Properties;

public class Email {

    public static boolean sendEmail(String to, String subject, String text) {
        Dotenv dotenv = Dotenv.load();
        String from = dotenv.get("EMAIL");
        String password = dotenv.get("PASSWORD");

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Create Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        // Create session
        Session session = Session.getInstance(props, auth);

        try {
            // Create Email
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject(subject);
            msg.setContent(text, "text/plain; charset=UTF-8");

            // Send email
            Transport.send(msg);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean sendEmailWithFile(String to, String subject, String textContent, String folder, String fileName) throws IOException {
// Cấu hình các thuộc tính của SMTP server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Sử dụng Gmail SMTP server
        properties.put("mail.smtp.port", "587"); // Cổng SMTP
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Tạo session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("managecinema2003@gmail.com", "adidafabtskmsbym"); // Thay bằng email và mật khẩu của bạn
            }
        });

        try {
            // Tạo đối tượng Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("managecinema2003@gmail.com")); // Thay bằng email của bạn
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("managecinemaa@gmail.com")); // Thay bằng email người nhận
            message.setSubject("Subject of the email");

            // Tạo phần nội dung chính của email
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(textContent);

            // Tạo phần đính kèm
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new FileDataSource(folder + "/" + fileName);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(fileName);

            // Tạo đối tượng multipart và thêm các phần vào
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            // Thiết lập nội dung email
            message.setContent(multipart);

            // Gửi email
            Transport.send(message);
            return true;
 
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    
    }

  

     public static void main(String[] args) {
        try {
            sendEmailWithFile("managecinemaa@gmail.com", "Subject of the email", "This is the email content.",
                    "C:\\ISP392_Project\\manage-cinema\\src\\main\\webapp\\assets\\cvs", "PT2_L2-cca4e4a3-918a-4bf2-b404-5742fbb5e9ec.docx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
