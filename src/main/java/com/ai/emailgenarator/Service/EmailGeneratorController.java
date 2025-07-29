package com.ai.emailgenarator.Service;


import com.ai.emailgenarator.io.EmailRequest;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailGeneratorController {
        @Value("${google.gemini.apiKeY}")
       private String apiKey ;
    // service to help us call api key
    public String response(EmailRequest request){
        // build the prompt to send to the gemini api
        String prompt = buildPrompt(request);
        // craft a request using sdk of google gemini
        //  send the request and return the response
        Client client = Client.builder().apiKey(apiKey).build();
        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        prompt,
                        null);
        return response.text();
    }

    private String buildPrompt(EmailRequest re){
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the  given email content , Please dont include Subject");
        if(re.getTone()  != null && !re.getTone().isEmpty()){
            prompt.append("Use a ").append(re.getTone()).append(" tone");


            }
        prompt.append("\n Original email :  \n").append(re.getEmailContent());

        return prompt.toString();
        }



    }

