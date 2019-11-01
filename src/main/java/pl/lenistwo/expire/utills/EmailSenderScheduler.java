package pl.lenistwo.expire.utills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lenistwo.expire.services.EmailSenderService;

@Component
public class EmailSenderScheduler {

    private EmailSenderService senderService;

    @Autowired
    public EmailSenderScheduler(EmailSenderService senderService) {
        this.senderService = senderService;
    }

    @Scheduled(cron = "0 15 6 * * *")
    private void logCurrentTime(){
        senderService.sendMessage("kacperek1003@gmail.com");
    }

}
