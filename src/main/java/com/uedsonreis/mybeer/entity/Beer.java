package com.uedsonreis.mybeer.entity;

import io.github.uedsonreis.libwscrud.api.entity.AbstractEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "beers")
public class Beer implements AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean valid;

    @CreatedDate
    private Date created;

    @LastModifiedDate
    private Date modified;

    private String name;
    private String type;
    private String description;
    private Integer ibu;
    private Float abv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_manufacturer", nullable = false)
    private Manufacturer manufacturer;

}
