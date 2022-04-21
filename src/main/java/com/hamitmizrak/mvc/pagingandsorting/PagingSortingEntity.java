package com.hamitmizrak.mvc.pagingandsorting;

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
@Table(name="paging" )
public class PagingSortingEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id//PK
    @GeneratedValue(strategy= GenerationType.IDENTITY)//AI
    @Column( name="id" , updatable = false)
    private Long pagingId;

    @Column( name="paging_name",unique = false)
    private String pagingName;

    @Column( name="created_date",insertable = false)
    @Temporal( TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

}


