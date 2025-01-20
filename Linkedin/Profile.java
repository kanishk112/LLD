
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Profile {
    private String profilePicture;
    private String headline;
    private String summary;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Skill> skills;

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSummary() {
        return summary;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
