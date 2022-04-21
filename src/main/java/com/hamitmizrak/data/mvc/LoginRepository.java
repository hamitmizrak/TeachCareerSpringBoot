package com.hamitmizrak.data.mvc;

import com.hamitmizrak.data.jpql.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,Long> {
}


