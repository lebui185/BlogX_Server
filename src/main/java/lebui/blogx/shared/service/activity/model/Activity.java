package lebui.blogx.shared.service.activity.model;

public class Activity {

    private String name;
    private String companyName;
    private double duration;

    public Activity() {
        super();
    }

    public Activity(String name, String companyName, double duration) {
        super();
        this.name = name;
        this.companyName = companyName;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

}
