package dev.saiteja.twilliodemo;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwiloInitializer {
    private final dev.saiteja.twilliodemo.TwilioConfiguration twilioConfiguration;

    private final static Logger LOGGER = LoggerFactory.getLogger(TwiloInitializer.class);

    @Autowired
    public TwiloInitializer(dev.saiteja.twilliodemo.TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        LOGGER.info("Twilio initialised with accoutn sid {}", twilioConfiguration.getAccountSid());
    }
}
