package dev.saiteja.twilliodemo;


@org.springframework.stereotype.Service
public class Service {
    private TwilioSmsSender twilioSmsSender;

    public Service( TwilioSmsSender twilioSmsSender) {
        this.twilioSmsSender = twilioSmsSender;
    }

    public void sendSms(SmsRequest smsRequest){
        twilioSmsSender.sendSms(smsRequest);
    }
}
