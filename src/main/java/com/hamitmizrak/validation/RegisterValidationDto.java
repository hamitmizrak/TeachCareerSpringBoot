package com.hamitmizrak.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

public class RegisterValidationDto {
    private int registerId;

    //şifre:root
    //email:root@root

    @NotEmpty(message = "kullanıcı adı ve soyadını boş geçemezsiniz")
    private String registerNameSurname;

    @NotEmpty(message = "email boş geçemezsiniz")
    @Email(message="uygun formatta yazmadınız örn: xyz@gmail.com")
    private String registerEmailAddress;

    @Min(value=18,message="18 yaşından küçükler başvuramaz")
    @Max(value=50,message="50 yaşından büyükler başvuramaz")
    private int  registerAge;

    @NotEmpty(message = "telefon boş geçemezsiniz")
    //@Pattern(regexp="[0-9\\s][9]")
    private String registerPhone;

    @NotEmpty(message = "message boş geçemezsiniz")
    @Size(min=1,max=100)
    private String registerMessages;

    //date
    public String getNowDate(){
        Locale locale=new Locale("tr","TR");
        SimpleDateFormat formatter =new SimpleDateFormat("dd-MMMM-yyyy hh:mm:ss",locale);
        String change=formatter.format(new Date(System.currentTimeMillis()));
        return change;
    }
    private String creationDate=getNowDate();

}
