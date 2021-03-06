package com.hamitmizrak.data.spesificquery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LaptopImpl  implements  ILaptop{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<LaptopEntity> findLaptopEntitiesBylaptopPrice(double price) {
        //sql != jpql
        //select * from teacher where price>=500
        String jpql="select lap from LaptopEntity lap where lap.laptopPrice>=:key";
        TypedQuery<LaptopEntity> typedQuery= entityManager.createQuery(jpql,LaptopEntity.class);
        typedQuery.setParameter("key",price);
        return typedQuery.getResultList();
    }
}
