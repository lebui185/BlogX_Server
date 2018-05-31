package lebui.blogx.shared.service.activity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.itextpdf.text.DocumentException;

import lebui.blogx.shared.service.activity.model.Activity;
import lebui.blogx.shared.service.activity.model.ActivityTimelineExportModel;
import lebui.blogx.shared.service.activity.model.Allocation;

public class ActivityServiceTest {

    @Test
    public void renderPdf() throws DocumentException, IOException {
        ActivityService activityService = setUpTestObject();
        ActivityTimelineExportModel reportModel = initData();

        byte[] pdf = activityService.renderPdf(reportModel);
        try (FileOutputStream fos = new FileOutputStream("report.pdf")) {
            fos.write(pdf);
        }
    }

    private ActivityService setUpTestObject() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        
        ActivityService activityService = new ActivityService();
        activityService.setTemplateEngine(templateEngine);

        return activityService;
    }

    private ActivityTimelineExportModel initData() {
        // Staff 01
        Allocation staff01Allocation = new Allocation();
        staff01Allocation.setStaffName("staff_01");

        List<Activity> staff01ActitiesInDays01 = new ArrayList<>();
        staff01ActitiesInDays01.add(new Activity("staff01_01_act01", "ABC construction", 1));
        staff01ActitiesInDays01.add(new Activity("staff01_01_act02", "ABC construction", 2));

        List<Activity> staff01ActitiesInDays02 = new ArrayList<>();
        staff01ActitiesInDays02.add(new Activity("staff01_02_act01", "ABC construction", 3));

        List<List<Activity>> staff01Activities = new ArrayList<>();
        staff01Activities.add(staff01ActitiesInDays01);
        staff01Activities.add(staff01ActitiesInDays02);

        staff01Allocation.setDailyActivities(staff01Activities);

        // Staff 02
        Allocation staff02Allocation = new Allocation();
        staff02Allocation.setStaffName("staff_01");

        List<Activity> staff02ActitiesInDays03 = new ArrayList<>();
        staff02ActitiesInDays03.add(new Activity("staff02_03_act01", "ABC construction", 4));
        staff02ActitiesInDays03.add(new Activity("staff02_03_act02", "ABC construction", 5));

        List<Activity> staff02ActitiesInDays04 = new ArrayList<>();
        staff02ActitiesInDays04.add(new Activity("staff02_04_act01", "ABC construction", 6));

        List<List<Activity>> staff02Activities = new ArrayList<>();
        staff02Activities.add(staff02ActitiesInDays03);
        staff02Activities.add(staff02ActitiesInDays04);

        staff02Allocation.setDailyActivities(staff02Activities);

        List<Allocation> allocations = new ArrayList<>();
        allocations.add(staff01Allocation);
        allocations.add(staff02Allocation);

        // model
        ActivityTimelineExportModel model = new ActivityTimelineExportModel();
        model.setTitle("Weekly report");
        model.setFromDate(LocalDate.of(2018, 5, 28));
        model.setToDate(LocalDate.of(2018, 6, 2));
        model.setAllocations(allocations);
        

        return model;
    }
}
