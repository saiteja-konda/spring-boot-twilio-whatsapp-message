package dev.saiteja.twilliodemo;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class TwilioSmsSender implements smsSender {
    private final TwilioConfiguration twilioConfiguration;

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneVaild(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber("whatsapp:"+smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber("whatsapp:+14155238886");
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(
                    to,
                    from,
                    message
            );

            creator.create();
            LOGGER.info("Send smsm{}" + smsRequest);
        } else {
            LOGGER.info("invalid phone number {}");
            throw new IllegalArgumentException("Phone number [" + smsRequest.getPhoneNumber() + "] is not valid");
        }

    }

    private boolean isPhoneVaild(String phoneNumber) {
        //use google phone number validator
        return true;
    }
}
