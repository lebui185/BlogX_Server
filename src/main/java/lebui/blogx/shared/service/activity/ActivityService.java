package lebui.blogx.shared.service.activity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.DocumentException;

import lebui.blogx.shared.service.activity.model.ActivityTimelineExportModel;

@Service
public class ActivityService {

    @Autowired
    private ITemplateEngine templateEngine;

    public void setTemplateEngine(ITemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] exportActivityTimelineToPdf(String from, String to, String allocateTo)
            throws DocumentException, IOException {
        ActivityTimelineExportModel model = buildModel(from, to, allocateTo);
        byte[] pdf = renderPdf(model);
        return pdf;
    }

    private ActivityTimelineExportModel buildModel(String from, String to, String allocateTo) {
        ActivityTimelineExportModel exportModel = new ActivityTimelineExportModel();
        exportModel.setTitle("lebui");
        return exportModel;
    }

    protected byte[] renderPdf(ActivityTimelineExportModel model) throws DocumentException, IOException {
        Context context = new Context();
        context.setVariable("model", model);

        String processedHtml = templateEngine.process("report", context);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(processedHtml);
        renderer.layout();
        renderer.createPDF(outputStream);
        byte[] pdfResult = outputStream.toByteArray();

        return pdfResult;
    }
}
