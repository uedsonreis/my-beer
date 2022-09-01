package com.uedsonreis.mybeer.repository;

import com.uedsonreis.mybeer.entity.Beer;
import io.github.uedsonreis.libwscrud.api.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends AbstractRepository<Beer, Long> {
}
