
import java.sql.Timestamp;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Job {
    private final String id;
    private final String title;
    private final String description;
    private final List<String> skills;
    private final String location;
    private final Timestamp postedAt;

    public Job(String id, String title, String description, List<String> skills, String location, Timestamp postedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.skills = skills;
        this.location = location;
        this.postedAt = postedAt;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getLocation() {
        return location;
    }

    public Timestamp getPostedAt() {
        return postedAt;
    }
}
