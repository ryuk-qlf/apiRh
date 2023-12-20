package fr.facil.facilapi.collections;


import fr.facil.facilapi.supplement.Options;
import fr.facil.facilapi.supplement.Timeformat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Calendar")
@Data
public class Calendar {

    @Id
    private String id;

    private User user;

    private String title;

    private String description;

    private String startDate;

    private Timeformat startTime;

    private String endDate;

    private Timeformat endTime;

    private List<Options> options;

    private List<String> guest;

    private boolean active;

    public Calendar(User user, String title, String description, String startDate, Timeformat startTime,
                    String endDate, Timeformat endTime, List<Options> options, List<String> guest, boolean active) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.options = options;
        this.guest = guest;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<String> getGuest() {
        return guest;
    }

    public void setGuest(List<String> guest) {
        this.guest = guest;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timeformat getStartTime() {
        return startTime;
    }

    public void setStartTime(Timeformat startTime) {
        this.startTime = startTime;
    }

    public Timeformat getEndTime() {
        return endTime;
    }

    public void setEndTime(Timeformat endTime) {
        this.endTime = endTime;
    }
}
