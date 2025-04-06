package com.studentmanagement.model;

import java.time.LocalDate;

public class Student {
    private long id;
    private String foreNames;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private Degree degree;

    public String getFirstName() {
        String firstname[] = foreNames.split(" ");
        return firstname[0];
    }

    public long getId() { return id;  }
    public void setId(long id) { this.id = id; }
    public String getForeNames() { return foreNames; }
    public void setForeNames(String foreNames) { this.foreNames = foreNames; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; } 
    public Degree getDegree() { return degree; }
    public void setDegree(Degree degree) { this.degree = degree; }    
    @Override
    public String toString() {
        return "Student [id=" + id + ", foreNames=" + foreNames + ", lastName=" + lastName + ", email=" + email
                + ", birthDate=" + birthDate + ", degree=" + degree + "]";
    }

}
