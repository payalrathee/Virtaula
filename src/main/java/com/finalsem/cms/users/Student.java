package com.finalsem.cms.users;

import com.finalsem.cms.entities.Course;
import com.finalsem.cms.entities.Submission;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String name;
    private long phoneNumber;
    private String email;
    private String password;
    private String dp;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="enrollment",
            joinColumns={@JoinColumn(name="student_id")},
            inverseJoinColumns={@JoinColumn(name="course_id")}
    )
    private List<Course> courses;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "student",cascade = CascadeType.ALL)
    private List<Submission> submissions;
    public Student() {
    }

    public Student(String name, String email, long phoneNumber, String password,String dp, List<Course> courses, List<Submission> submissions) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.dp=dp;
        this.courses = courses;
        this.submissions = submissions;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name=" + name +
                '}';
    }
}
