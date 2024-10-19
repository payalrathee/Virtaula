package com.virtaula.entities;

import jakarta.persistence.*;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int assignmentId;
    private String topic;
    private String description;
    @Lob
    private Blob questionSet;
    private Date deadline;
    private int marks;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course")
    private Course course;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "assignment")
    private List<Submission> submissions;

    public Assignment() {
    }

    public Assignment(String topic,String description, Blob questionSet, Date deadline, int marks, Course course, List<Submission> submissions) {
        this.topic = topic;
        this.description=description;
        this.questionSet = questionSet;
        this.deadline = deadline;
        this.marks = marks;
        this.course = course;
        this.submissions = submissions;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Blob getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Blob questionSet) {
        this.questionSet = questionSet;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId=" + assignmentId +
                ", topic='" + topic + '\'' +
                '}';
    }
}
