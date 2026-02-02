package dezines.LowLevelDesign.NotifyMe.strategy;

import dezines.LowLevelDesign.NotifyMe.dto.MessageContent;
import dezines.LowLevelDesign.NotifyMe.dto.User;

public interface NotificationStrategy {

     void sendMessage(User User, MessageContent msg);
}
