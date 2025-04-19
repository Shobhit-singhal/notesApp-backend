package com.shobhit.Backend.dto;

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
public class UserLoginReqDTO {
    @NotNull
    @NotBlank(message = "username cant be blank")
    private String username;
    @NotNull
    @NotBlank(message = "password cant be blank")
    private String password;
}
