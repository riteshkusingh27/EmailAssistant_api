package com.ai.emailgenarator.io;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EmailRequest {
    private String emailContent ;
    private String tone ;

}
