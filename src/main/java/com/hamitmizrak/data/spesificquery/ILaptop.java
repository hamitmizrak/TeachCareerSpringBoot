package com.hamitmizrak.data.spesificquery;

import java.util.List;

public interface ILaptop {
//findTeacherEntitiesByTeacherSurname
    public List<LaptopEntity> findLaptopEntitiesBylaptopPrice(double price);
}
