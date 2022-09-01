package com.uedsonreis.mybeer.api.controller;

import com.uedsonreis.mybeer.api.dto.BeerDTO;
import com.uedsonreis.mybeer.entity.Beer;
import com.uedsonreis.mybeer.service.BeerService;
import io.github.uedsonreis.libwscrud.api.controller.AbstractController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("${app.api.base}/beers")
public class BeerController extends AbstractController<Beer, BeerDTO, Long> {

    @Getter
    private final BeerService service;

    public BeerController(BeerService service) {
        super(BeerController.class);
        this.service = service;
    }

    protected <D> D parser(Object obj, Class<D> c) {
        if (obj == null) return null;
        return this.mapper.map(obj, c);
    }

    @Override
    protected BeerDTO parserTO(Beer beer) {
        return this.parserDTO(beer);
    }
    protected BeerDTO parserDTO(Beer beer) {
        return this.parser(beer, BeerDTO.class);
    }

    @Override
    protected Beer parserEntity(BeerDTO dto) {
        return this.parser(dto, Beer.class);
    }

    @Override
    protected BeerDTO convert(String json) {
        return this.jsonParser.toObject(json, BeerDTO.class);
    }

    @Override
    protected Page<BeerDTO> parserPageDTO(Page<Beer> page) {
        return this.mapper.mapPage(page, BeerDTO.class);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(
            path = "/test",
            produces = {"application/json"}
    )
    public BeerDTO store(@RequestBody @Valid BeerDTO dto, @RequestHeader RequestHeader header) throws Exception {

        return super.store(dto);
    }

}
