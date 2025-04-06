package com.studentmanagement.model;

import java.util.List;

public class Degree {
    private long id;
    private String name;
    private int duration;
    private Lecture lecture;
    private List<Course> courses;
    
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public Lecture getLecture() { return lecture;  }
    public void setLecture(Lecture lecture) { this.lecture = lecture; }
    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }   

    @Override
    public String toString() {
        return "Degree [id=" + id + ", name=" + name + ", duration=" + duration + ", lecture=" + lecture + ", courses="
                + courses + "]";
    }

}
