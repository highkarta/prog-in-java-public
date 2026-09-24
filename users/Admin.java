package users;
/**
 * Admin
 */
public class Admin extends User{
    private int adminId;

    Admin(int userId, String name, String email, String password, UserRole role, boolean active, int adminId){
        super(userId, name, email, password, role, active);
        this.adminId = adminId;
    }

    void manageUsers(){}
    void manageCompanies(){}
    void manageJobs(){}
    void manageApplications(){}
    void viewRecruitmentActivity(){}
    void generatePlacementReport(){}
}