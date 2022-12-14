package com.uedsonreis.mybeer.service;

import com.uedsonreis.mybeer.entity.Manufacturer;
import com.uedsonreis.mybeer.repository.ManufacturerRepository;
import io.github.uedsonreis.libwscrud.api.service.AbstractService;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService extends AbstractService<Manufacturer, Long> {

    @Getter
    private final ManufacturerRepository repository;

    public ManufacturerService(ManufacturerRepository repository) {
        super(ManufacturerService.class);
        this.repository = repository;
    }

    @Override
    protected void updateFields(Manufacturer toSave, Manufacturer newValues) {
        super.mapper.map(newValues, toSave);
    }
}
