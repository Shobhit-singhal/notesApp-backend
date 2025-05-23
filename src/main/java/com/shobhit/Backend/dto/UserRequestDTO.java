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
public class UserRequestDTO {
    @NotNull
    @NotBlank(message = "Username Can't be blank")
    private String username;
    @NotNull
    @NotBlank(message = "Password Can't be blank")
    private String password;
    @NotNull
    @NotBlank(message = "Gender Can't be blank")
    private String gender;
}
