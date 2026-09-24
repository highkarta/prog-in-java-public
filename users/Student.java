package users;
import java.util.*;

import Skill;

public class Student extends User{
    private int studentId;
    private String registrationNo;
    private String branch;
    private double cgpa;
    private int graduationYear;
    private String resumePath;
    private List<Skill> skill; // is this how you're supposed to implement Skill?

    Student(int userId, String name, String email, String password, UserRole role, boolean active, int studentId, String registrationNo, String branch, double cgpa, int graduationYear, String resumePath){
        super(userId, name, email, password, role, active);
        // isn't studentId same as userId?
        this.studentId = studentId;
        this.registrationNo = registrationNo;
        this.branch = branch;
        this.cgpa = cgpa;
        this.graduationYear = graduationYear;
        this.resumePath = resumePath;
    }

    // override the getProfile instead

    void addSkill(Skill){}

    void removeSkill(int skillId){}

    void addProject(Project){}

    void removeProject(int projectId){}

    List<Job> searchJobs(String keyword){}

    Application applyForJob(Job){}

    List<Application> viewApplications(){}

    List<Interview> viewInterviews(){}

    List<Offer> viewOffers(){}

    List<Notification> viewNotifications(){}
}