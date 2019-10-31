package pl.lenistwo.expire.utills;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class EmailSenderScheduler {

    @Scheduled(cron = "0 15 6 * *")
    private void logCurrentTime(){
        System.out.println(LocalTime.now());
    }

}
