package com.uedsonreis.mybeer.repository;

import com.uedsonreis.mybeer.entity.Manufacturer;
import io.github.uedsonreis.libwscrud.api.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends AbstractRepository<Manufacturer, Long> {
}
