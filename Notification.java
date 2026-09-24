import java.time.LocalDateTime;

public class Notification{
    private int notificationId;
    private String message;
    private NotificationType type;
    private LocalDateTime createdOn;
    private boolean isRead;

    void markAsRead(){}
    void markAsUnread(){}
}