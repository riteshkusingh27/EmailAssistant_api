package com.ai.emailgenarator.Controller;


import com.ai.emailgenarator.Service.EmailGeneratorService;
import com.ai.emailgenarator.io.EmailRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class EmailGenerator {

    private final EmailGeneratorService emailGeneratorService;
    public EmailGenerator(EmailGeneratorService emailGeneratorController) {
        this.emailGeneratorService = emailGeneratorController;
    }
    @PostMapping("/generate-mail")
    @CrossOrigin(origins = "*")
    public String generateEmail(@RequestBody EmailRequest email){
        return  emailGeneratorService.response(email);
    }
}
