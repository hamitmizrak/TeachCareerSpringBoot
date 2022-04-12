package com.hamitmizrak.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class BeanDto {

   private long id;
   private String beanName;
   private String beanData;

   public void initialBeanMethod(){
      log.error("Start Bean başladı");
      System.out.println("Start Bean başladı");
   }

   public void destroyBeanMethod(){
      log.error("Finish Bean bitti");
      System.out.println("Finish Bean bitti");
   }
}
