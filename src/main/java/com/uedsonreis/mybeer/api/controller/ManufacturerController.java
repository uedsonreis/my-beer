package com.uedsonreis.mybeer.api.controller;

import com.uedsonreis.mybeer.api.dto.ManufacturerDTO;
import com.uedsonreis.mybeer.entity.Manufacturer;
import com.uedsonreis.mybeer.service.ManufacturerService;
import io.github.uedsonreis.libwscrud.api.controller.AbstractController;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.api.base}/manufacturers")
public class ManufacturerController extends AbstractController<Manufacturer, ManufacturerDTO, Long> {

    @Getter
    private final ManufacturerService service;

    public ManufacturerController(ManufacturerService service) {
        super(ManufacturerController.class);
        this.service = service;
    }

    protected <D> D parser(Object obj, Class<D> c) {
        if (obj == null) return null;
        return this.mapper.map(obj, c);
    }

    @Override
    protected ManufacturerDTO parserTO(Manufacturer manufacturer) {
        return this.parserDTO(manufacturer);
    }
    protected ManufacturerDTO parserDTO(Manufacturer manufacturer) {
        return this.parser(manufacturer, ManufacturerDTO.class);
    }

    @Override
    protected Manufacturer parserEntity(ManufacturerDTO dto) {
        return this.parser(dto, Manufacturer.class);
    }

    @Override
    protected ManufacturerDTO convert(String json) {
        return jsonParser.toObject(json, ManufacturerDTO.class);
    }

    @Override
    protected Page<ManufacturerDTO> parserPageDTO(Page<Manufacturer> page) {
        return this.mapper.mapPage(page, ManufacturerDTO.class);
    }
}
