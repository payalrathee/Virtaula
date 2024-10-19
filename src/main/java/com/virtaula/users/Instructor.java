package com.virtaula.users;

import com.virtaula.entities.Course;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int instructorId;
    private String name;
    private String email;
    private String password;
    private long phoneNumber;
    private String dp;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="instructor_offering",
            joinColumns = {@JoinColumn(name="instructor_id")},
            inverseJoinColumns={@JoinColumn(name="course_id")}
    )
    private List<Course> courses;

    public Instructor() {
    }

    public Instructor(String name, String email, long phoneNumber, String password, List<Course> courses,String dp) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.courses = courses;
        this.dp=dp;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorId=" + instructorId +
                ", name='" + name + '\'' +
                '}';
    }
}
