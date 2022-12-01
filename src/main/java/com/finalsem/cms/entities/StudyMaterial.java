package com.finalsem.cms.entities;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
public class StudyMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int studyMaterialId;
    @Lob
    Blob file;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course")
    Course course;

    public StudyMaterial() {
    }

    public StudyMaterial(Blob file, Course course) {
        this.file = file;
        this.course = course;
    }

    public int getStudyMaterialId() {
        return studyMaterialId;
    }

    public void setStudyMaterialId(int studyMaterialId) {
        this.studyMaterialId = studyMaterialId;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudyMaterial{" +
                "file=" + file +
                '}';
    }
}
