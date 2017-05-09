package com.travelagency.services;


import com.travelagency.models.bindingModels.CruiseDto;
import com.travelagency.models.viewModels.CruiseDetailViewModel;
import com.travelagency.models.viewModels.CruiseViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CruiseService {

    void create(CruiseDto cruiseDto);

    CruiseDetailViewModel findById(long id);

    Page<CruiseViewModel> findAll(Pageable pageable);
}
