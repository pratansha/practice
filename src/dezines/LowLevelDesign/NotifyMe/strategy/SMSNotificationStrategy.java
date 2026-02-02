package dezines.LowLevelDesign.NotifyMe.strategy;

import dezines.LowLevelDesign.NotifyMe.dto.MessageContent;
import dezines.LowLevelDesign.NotifyMe.dto.User;

public class SMSNotificationStrategy implements NotificationStrategy {

    @Override
    public void sendMessage(User user, MessageContent msg) {
        // Logic to send message over the mobile number to a user.
        System.out.println(user.getUserName() + " is now sending sms on " + user.getMobileNumber() + " for the productName :" + msg.getProduct().getProductName());
    }
}
