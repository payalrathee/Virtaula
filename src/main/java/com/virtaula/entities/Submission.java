package com.virtaula.entities;

import com.virtaula.users.Student;
import jakarta.persistence.*;

import java.sql.Blob;
import java.util.Date;

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fileId;
    @Lob
    private Blob file;
    private Date submissionDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student")
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="assignment")
    private Assignment assignment;

    public Submission() {
    }

    public Submission(Blob file, Date submissionDate, Student student, Assignment assignment) {
        this.file = file;
        this.submissionDate = submissionDate;
        this.student = student;
        this.assignment = assignment;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
