package com.shobhit.Backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteReqDTO {
    @NotNull
    @NotBlank(message = "title cant be blank")
    private String title;
    @NotNull
    @NotBlank(message = "content cant be blank")
    private String content;
}
