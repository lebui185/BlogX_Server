package lebui.blogx.webservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import lebui.blogx.shared.service.activity.ActivityService;

@RestController
@RequestMapping("/test")
public class TestController {
    
    @Autowired
    private ActivityService activityService;
    
    @GetMapping(produces = "application/pdf")
    public byte[] generateReport() throws DocumentException, IOException {
        byte[] pdf = activityService.exportActivityTimelineToPdf(null, null, null);
        return pdf;
    }
}
