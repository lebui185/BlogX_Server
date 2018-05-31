package lebui.blogx.shared.service.activity.model;

import java.util.List;

public class Allocation {

    private String staffName;
    private List<List<Activity>> dailyActivities;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public List<List<Activity>> getDailyActivities() {
        return dailyActivities;
    }

    public void setDailyActivities(List<List<Activity>> dailyActivities) {
        this.dailyActivities = dailyActivities;
    }

}
