package com.hamitmizrak.jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {

    //kendi sorgumu kendim yapmak istiyorum.
    //1.adım: Entity ile aynı olacak  ==>teacherSurname
    //2.adım: find,delete,count,get,  ==> find
    //3.adım: Yazdığım Entity ismine göre yazmak ==>find_1_TeacherEntities
    //4.adım: sona By ekle
    //5.adım: TeacherSurname ==> find_1_TeacherEntitiesByTeacherSurname
    List<TeacherEntity> findTeacherEntitiesByTeacherSurname (String teacherSurname);

}
