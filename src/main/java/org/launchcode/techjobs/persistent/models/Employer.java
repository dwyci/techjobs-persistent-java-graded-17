package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Size(min = 0, max = 100)
public class Employer extends AbstractEntity {
    @NotBlank
    @Size(min = 0, max = 100)
    private String location;
    @OneToMany(mappedBy = "employer")
    @JoinColumn(name = "employer_id")
    private List<Job>  jobs = new ArrayList<>();

    public void setJob(List<Job> jobs){
        this.jobs = jobs;
    }
    // No-argument constructor required by Hibernate
    public Employer() {
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
