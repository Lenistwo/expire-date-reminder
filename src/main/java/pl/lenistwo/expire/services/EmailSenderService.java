package pl.lenistwo.expire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.lenistwo.expire.repositories.ItemRepository;
import pl.lenistwo.expire.utills.MessageBuilder;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;

@Service
public class EmailSenderService {

    private JavaMailSender sender;
    private ItemRepository repo;

    @Autowired
    public EmailSenderService(JavaMailSender sender, ItemRepository repo) {
        this.sender = sender;
        this.repo = repo;
    }

    @Async
    public void sendMessage(String to) {
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("This Products Will soon expire");
            mimeMessageHelper.setText(MessageBuilder.
                    build(repo.
                            findAllByExpireDateIsLessThan(
                                    LocalDate.now())), true);
            sender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
