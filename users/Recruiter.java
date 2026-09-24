/**
 * Recruiter
 */
public class Recruiter extends User{
    private int recruiterId;
    private String designation;
    private Company company;

    Recruiter(int userId, String name, String email, String password, UserRole role, boolean active, int recruiterId, String designation, Company company){
        super(userId, name, email, password, role, active);
        this.recruiterId = recruiterId;
        this.designation = designation;
        this.company = company;
    }

    void createJob(Job){}

    void updateJob(Job){}

    void closeJob(int jobId){}

    List<Application> viewApplicants(Job){}

    void shortlistApplicant(Application){}

    Interview scheduleInterview(Application, LocalDate){ } // wrong

    Offer issueOffer(Application){}
	
}