package com.hamitmizrak.data.spesificquery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//1.YOL
//public interface ILaptop {
////findTeacherEntitiesByTeacherSurname
//    public List<LaptopEntity> findLaptopEntitiesBylaptopPrice(double price);
//}


//2.YOL
public interface ILaptop {
    //findTeacherEntitiesByTeacherSurname
    public List<LaptopEntity> findLaptopEntitiesBylaptopPrice(double price);
}
