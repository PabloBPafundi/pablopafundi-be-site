package com.pablopafundi.site.curriculum;


import com.pablopafundi.site.common.domain.LanguageEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/")
public class CurriculumController {

    private final PdfGenerationService pdfGenerationService;

    public CurriculumController(PdfGenerationService pdfGenerationService) {
        this.pdfGenerationService = pdfGenerationService;
    }

    @GetMapping("{lang}/curriculum")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable("lang")LanguageEnum lang) {

        byte[] pdf = pdfGenerationService.generatePdf(lang);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=PabloPafundiCV.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }


}
