package com.hamitmizrak.data.spesificquery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "laptop")
public class LaptopEntity implements Serializable {
    //serilestirme
    public final static long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long laptopId;

    @Column(name = "laptop_name")
    private String laptopName;

    @Column(name = "laptop_price")
    private double laptopPrice;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date creationDate;


}
