package com.uedsonreis.mybeer.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    private Long id;
    private String name;
    private String type;
    private String manufacturer;
    private String description;
    private Integer ibu;
    private Float abv;

}
