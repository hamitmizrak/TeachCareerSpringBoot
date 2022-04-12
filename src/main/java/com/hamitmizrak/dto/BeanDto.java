package com.hamitmizrak.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeanDto {

   private long id;
   private String beanName;
   private String beanData;
}
