package com.SpringSecurity.SpringSecurity1.dto;

import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@Data
public class PostDTO {
    private Long id;
    private String title;
    private String description;
}
