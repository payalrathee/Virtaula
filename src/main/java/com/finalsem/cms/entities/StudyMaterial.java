package com.finalsem.cms.entities;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
public class StudyMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int studyMaterialId;
    private String title;
    private String description;
    @Lob
    Blob file;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")
    Course course;

    public StudyMaterial() {
    }

    public StudyMaterial(Blob file, String title,String description, Course course) {
        this.file = file;
        this.title = title;
        this.description=description;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                "title='" + title + '\'' +
                '}';
    }
}
