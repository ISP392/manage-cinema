/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.activation.*;


/**
 *
 * @author ACER
 */
public class SendEmailWithAttachment {
   public static void main(String[] args) {
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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("daothihabg03@gmail.com")); // Thay bằng email người nhận
            message.setSubject("Subject of the email");

            // Tạo phần nội dung chính của email
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("This is the message body");

            // Tạo phần đính kèm
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filePath = "C:\\ISP392_Project\\manage-cinema\\src\\main\\webapp\\assets\\cvs\\"; // Thay bằng đường dẫn file của bạn
            DataSource source = new FileDataSource(filePath);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName("file.docx"); // Tên file sẽ hiển thị khi người nhận mở email

            // Tạo đối tượng multipart và thêm các phần vào
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            // Thiết lập nội dung email
            message.setContent(multipart);

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully with attachment.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
