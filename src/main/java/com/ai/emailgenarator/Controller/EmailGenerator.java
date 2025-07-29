package com.ai.emailgenarator.Controller;


import com.ai.emailgenarator.Service.EmailGeneratorService;
import com.ai.emailgenarator.io.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class EmailGenerator {
    @Autowired
    private final EmailGeneratorService emailGeneratorService;
    public EmailGenerator(EmailGeneratorService emailGeneratorService) {
        this.emailGeneratorService = emailGeneratorService;
    }
    @PostMapping("/generate-mail")
    @CrossOrigin(origins = "*")
    public String generateEmail(@RequestBody EmailRequest email){
        return  emailGeneratorService.response(email);
    }
}
