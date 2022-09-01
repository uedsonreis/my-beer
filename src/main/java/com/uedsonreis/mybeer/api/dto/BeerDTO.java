package com.uedsonreis.mybeer.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.uedsonreis.libwscrud.api.dto.AbstractEntityDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Beer")
public class BeerDTO implements AbstractEntityDTO<Long> {

    private Long id;
    private Boolean valid;
    private Date created;
    private Date modified;
    private String modifierUser;

    @NotEmpty
    private String name;

    private String type;
    private String description;
    private Integer ibu;
    private Float abv;

    @NotNull
    private ManufacturerDTO manufacturer;

}
