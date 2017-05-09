package com.travelagency.services;

import com.travelagency.models.viewModels.AirlineViewModel;
import java.util.List;

public interface AirlineService {

    List<AirlineViewModel> findAll();
}
