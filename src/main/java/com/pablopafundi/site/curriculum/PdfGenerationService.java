package com.pablopafundi.site.curriculum;


import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.pablopafundi.site.common.domain.LanguageEnum;
import com.pablopafundi.site.knowledge.KnowledgeResponseDTO;
import com.pablopafundi.site.knowledge.SkillType;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfGenerationService {

    private final CurriculumService curriculumService;
    private final TemplateEngine templateEngine;

    public PdfGenerationService(CurriculumService curriculumService, TemplateEngine templateEngine) {
        this.curriculumService = curriculumService;
        this.templateEngine = templateEngine;
    }

    public byte[] generatePdf(LanguageEnum lang) {

        CurriculumDTO curriculumData = curriculumService.getCV(lang);

        List<KnowledgeResponseDTO> knowLedgeLanguages = curriculumData.knowledge().stream().filter(knowledgeResponseDTO -> knowledgeResponseDTO.skillType() == SkillType.LANGUAGE).toList();

        List<KnowledgeResponseDTO> knowLedges = curriculumData.knowledge().stream().filter(knowledgeResponseDTO -> knowledgeResponseDTO.skillType() != SkillType.LANGUAGE).toList();

        Context context = new Context();
        context.setVariable("profile", curriculumData.myProfile());
        context.setVariable("workExperience", curriculumData.workExperience());
        context.setVariable("education", curriculumData.education());
        context.setVariable("contact", curriculumData.contact());
        context.setVariable("knowLedgeLanguages", knowLedgeLanguages);
        context.setVariable("knowledge", knowLedges);
        context.setVariable("language", lang);

        String htmlContent = templateEngine.process("PabloPafundiCV", context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, "file:./src/main/resources/");
            builder.toStream(outputStream);
            builder.run();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error", e);
        }
    }
}