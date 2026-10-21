package practice.assn5;

import java.sql.Array;
import java.util.*;

/**
 * Employee
 */
public class Employee {

    private String employeeId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String designation;
    private String department;
    private String skills;
    private String about;

    Employee(
        String employeeId,
        String fullName,
        String email,
        String phoneNumber,
        String designation,
        String department,
        String skills,
        String about
    ) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
        this.department = department;
        this.skills = skills;
        this.about = about;
    }

    String getEmployeeId() {
        return this.employeeId;
    }

    String getFullName() {
        return this.fullName;
    }

    String getEmail() {
        return this.email;
    }

    String getPhoneNumber() {
        return this.phoneNumber;
    }

    String getDesignation() {
        return this.designation;
    }

    String getDepartment() {
        return this.department;
    }

    String getSkills() {
        return this.skills;
    }

    String getAbout() {
        return this.about;
    }

    void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    void setFullName(String fullName) {
        this.fullName = fullName;
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void setDesignation(String designation) {
        this.designation = designation;
    }

    void setDepartment(String department) {
        this.department = department;
    }

    void setSkills(String skills) {
        this.skills = skills;
    }

    void setAbout(String about) {
        this.about = about;
    }

    void nameProcessing() {
        getFullName().trim();
        // getFullName().toUpperCase();
        // int len = getFullName().length();
        // getFullName().charAt(0);
        // getFullName().charAt(len - 1);
        String[] names = getFullName().trim().split(" ");
        String firstName = names[0];
        String middleName = names[1];
        String lastName = names[2];
        int words = names.length;
        String initials = generateInitials(names);
        System.out.println(initials);
    }

    String generateInitials(String[] names) {
        StringBuilder initials = new StringBuilder("");
        for (int i = 0; i < names.length; i++) {
            initials.append(names[i].charAt(0));
        }
        return initials.toString();
    }

    void emailProcessing() {
        String mail = getEmail().trim().toLowerCase();
        int at = mail.indexOf('@');
        String userName = mail.substring(0, at);
        System.out.println(userName);
        String domain = mail.substring(at + 1, mail.length());
        System.out.println(domain);
        if (mail.indexOf('@') != -1) {
            System.out.println("exists");
        } else {
            System.out.println("not exists");
        }
        // mail.startsWith(prefix) // useful method
        if (mail.endsWith(".com")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        if (mail.contains("example.com")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        if (domain.equalsIgnoreCase("example.com")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    void phoneProcessing() {
        StringBuilder phone = new StringBuilder(getPhoneNumber().trim());
        phone.deleteCharAt(getPhoneNumber().indexOf('-'));
        int len = phone.length();
        String f3 = phone.substring(0, 3);
        String l4 = phone.substring(len - 4, len);
        System.out.println(f3);
        System.out.println(l4);
        if (len == 10) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    void designationProcessing() {
        String mod = getDesignation().trim().replaceAll(" ", "-");
        System.out.println(mod);
    }

    void skillsProcessing() {
        String[] skillArr = skills.split(", ");
        List<String> mainList = Arrays.asList(skillArr);
        if (mainList.contains("Python")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        int last = getSkills().lastIndexOf(',');
        System.out.println(last);
        String newVal = getSkills().replaceAll(", ", " | ");
        System.out.println(newVal);
    }

    void idProcessing() {
        String toExtract = "EMP";
        int start = getEmployeeId().indexOf(toExtract);
        String ext = getEmployeeId().substring(
            start,
            start + toExtract.length()
        );
        System.out.println(ext);

        int index = 0;
        for (int j = 0; j < getEmployeeId().length(); j++) {
            if (Character.isDigit(getEmployeeId().charAt(j))) {
                index = j;
                break;
            }
        }

        String numeric = getEmployeeId().substring(index, getEmployeeId().length());
        System.out.println(numeric);
    }

    public void displayProfile(){
        System.out.println("===== EMPLOYEE PROFILE ======");
        System.out.println("Employee ID     : " + getEmployeeId());
        // how do you finally manipulate variables
    }

    public static void main(String[] args) {
        String employeeId = "EMP20261025";
        String fullName = "   Rahul Kumar Sharma   ";
        String email = "   Rahul.Sharma@Example.COM   ";
        String phoneNumber = "98765-43210";
        String designation = "Software Engineer";
        String department = "Java Development";
        String skills = "Java, Spring Boot, SQL, React, Docker";
        String about =
            "Java developer with experience in building scalable web applications";

        Employee e = new Employee(
            employeeId,
            fullName,
            email,
            phoneNumber,
            designation,
            department,
            skills,
            about
        );
        e.displayProfile();
    }
}
