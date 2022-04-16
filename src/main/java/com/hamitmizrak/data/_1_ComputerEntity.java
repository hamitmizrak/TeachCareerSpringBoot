package com.hamitmizrak.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="computer" )
public class _1_ComputerEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id//PK
    @GeneratedValue(strategy= GenerationType.IDENTITY)//AI
    @Column( name="id" , updatable = false)
    private Long computerId;

    @Column( name="computer_name",unique = true)
    private String computerName;

    @Column( name="computer_trade")
    private String computerTrade;

    @Column( name="computer_price",length=7,nullable = false)
    private double computerPrice;

    @Column( name="created_date",insertable = false)
    @Temporal( TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

}
