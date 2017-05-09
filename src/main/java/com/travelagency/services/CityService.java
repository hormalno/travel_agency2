package com.travelagency.services;

import com.travelagency.models.viewModels.CityViewModel;

import java.util.List;

public interface CityService {

    List<CityViewModel> findAll();
}
