package com.finalsem.cms.entities;

import com.finalsem.cms.users.Instructor;
import com.finalsem.cms.users.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseId;
    private String name;
    private double duration;
    private int batchSize;
    private String subject;
    @Embedded
    private Schedule schedule;
    private double price;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "course",cascade = CascadeType.ALL)
    private List<Assignment> assignments;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "course",cascade = CascadeType.ALL)
    private List<StudyMaterial> material;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "courses")
    private List<Student> students;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "courses")
    private List<Instructor> instructors;

    public Course() {
    }

    public Course(String name, double duration, int batchSize, String subject, Schedule schedule, double price, List<Assignment> assignments, List<StudyMaterial> material, List<Student> students, List<Instructor> instructors) {
        this.name = name;
        this.duration = duration;
        this.batchSize = batchSize;
        this.subject = subject;
        this.schedule = schedule;
        this.price = price;
        this.assignments = assignments;
        this.material = material;
        this.students = students;
        this.instructors = instructors;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<StudyMaterial> getMaterial() {
        return material;
    }

    public void setMaterial(List<StudyMaterial> material) {
        this.material = material;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                '}';
    }
}
