package com.uedsonreis.mybeer.entity;

import io.github.uedsonreis.libwscrud.api.entity.AbstractEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "manufacturers")
@EntityListeners(AuditingEntityListener.class)
public class Manufacturer implements AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private Boolean valid = true;

    @CreatedDate
    private Date created;

    @LastModifiedDate
    private Date modified;

    @LastModifiedBy
    @Column(name = "modifier_user")
    private String modifierUser;

    private String name;
    private String description;
}