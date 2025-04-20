package com.shobhit.Backend.dto;

import com.shobhit.Backend.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoReqDTO {
    @NotNull
    @NotBlank(message = "task cant be blank")
    private String task;



}
