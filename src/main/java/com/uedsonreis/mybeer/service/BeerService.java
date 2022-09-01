package com.uedsonreis.mybeer.service;

import com.uedsonreis.mybeer.entity.Beer;
import com.uedsonreis.mybeer.repository.BeerRepository;
import io.github.uedsonreis.libwscrud.api.entity.AbstractEntity;
import io.github.uedsonreis.libwscrud.api.service.AbstractService;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class BeerService extends AbstractService<Beer, Long> {

    @Getter
    private final BeerRepository repository;

    public BeerService(BeerRepository repository) {
        super(BeerService.class);
        this.repository = repository;
    }

    protected void updateFields(Beer toSave, Beer newValues) {
        super.mapper.map(newValues, toSave);
    }

}
