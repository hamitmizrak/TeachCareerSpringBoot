package com.hamitmizrak.data.mvc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class LoginDto {

    private long loginId;

    @NotEmpty(message = "email boş geçilemez")
    @Email(message="uygun formatta girmediniz exm: xyz@gmail.com")
    private String loginEmail;

    @NotEmpty(message = "şifre boş geçilemez.")
    private String loginPassword;
}
