package dezines.LowLevelDesign.NotifyMe.strategy;

import dezines.LowLevelDesign.NotifyMe.dto.MessageContent;
import dezines.LowLevelDesign.NotifyMe.dto.User;

public class EmailNotificationStrategy implements NotificationStrategy {
    @Override
    public void sendMessage(User user, MessageContent msg) {
        // Logic to send message over an email to a user.
        System.out.println(user.getUserName() + " is now notified on emailId:" + user.getEmailId() + "+ for the productName :" + msg.getProduct().getProductName());
    }
}
