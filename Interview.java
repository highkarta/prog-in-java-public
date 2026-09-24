import java.time.LocalDateTime;

public class Interview{
    private int interviewId;
    private String type;
    private LocalDateTime scheduledOn;
    private String mode;
    private InterviewStatus status;
    private String feedback;

    void updateStatus(InterviewStatus){}

    void addFeedback(String){}

    void reschedule(LocalDateTime){}

    void cancel(){}
}