package com.hamitmizrak.data.mvc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2


@Entity
@Table(name="admin_entity" )
public class LoginEntity {

    @Id//PK
    @GeneratedValue(strategy= GenerationType.IDENTITY)//AI
    @Column( name="id" , updatable = false)
    private long loginId;

    @Column( name="email")
    private String loginEmail;

    @Column( name="password")
    private String loginPassword;
}
