package com.studentmanagement.model;

import java.time.LocalDate;
import java.util.List;

public class Lecture {
    private long id;
    private String foreNames;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    List<Degree> degrees;
    
    public long getId() { return id;  }
    public void setId(long id) { this.id = id; }
    public String getForeNames() { return foreNames; }
    public void setForeNames(String foreNames) { this.foreNames = foreNames; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Degree> getDegrees() { return degrees; }
    public void setDegrees(List<Degree> degrees) { this.degrees = degrees; }
    public LocalDate getBirthDate() { return birthDate;  }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate;  }
    
    @Override
    public String toString() {
        return "Lecture [id=" + id + ", foreNames=" + foreNames + ", lastName=" + lastName + ", email=" + email
                + ", birthDate=" + birthDate + ", degrees=" + degrees + "]";
    }

    

}
