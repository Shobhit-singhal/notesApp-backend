package com.shobhit.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteResponseDTO {
    private long id;
    private String title;
    private String content;
    private LocalDate date;
}
