package com.SpringSecurity.SpringSecurity1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class SignUpDto {
   private String email;
   private String password;
   private String name;
}
