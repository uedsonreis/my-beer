package com.uedsonreis.mybeer.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.uedsonreis.libwscrud.api.dto.AbstractEntityDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Manufacturer")
public class ManufacturerDTO implements AbstractEntityDTO<Long> {

    private Long id;
    private Boolean valid;
    private Date created;
    private Date modified;

    @NotEmpty()
    private String name;
    private String description;

}
