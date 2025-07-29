package com.ai.emailgenarator.Controller;


import com.ai.emailgenarator.Service.EmailGeneratorController;
import com.ai.emailgenarator.io.EmailRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class EmailGenerator {
    @Autowired
    private EmailGeneratorController emailGeneratorController;
    @PostMapping("/generate-mail")
    @CrossOrigin(origins = "*")
    public String generateEmail(@RequestBody EmailRequest email){
        return  emailGeneratorController.response(email);
    }
}
