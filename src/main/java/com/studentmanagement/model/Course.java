package com.studentmanagement.model;

import java.util.List;

public class Course {
    private long id;
    private String name;
    private int duration_months;
    private List<Course> courses;
    private Degree degree;
    
    
    public long getId() { return id; }
    public void setId(long id) {  this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getDuration_months() { return duration_months; }
    public void setDuration_months(int duration_months) { this.duration_months = duration_months; }
    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
    public Degree getDegree() {  return degree; }
    public void setDegree(Degree degree) { this.degree = degree; }

   

}
