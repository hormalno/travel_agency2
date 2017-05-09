package com.travelagency.services;

import com.travelagency.models.bindingModels.ReviewDto;
import com.travelagency.models.viewModels.ReviewByUserViewModel;
import com.travelagency.models.viewModels.ReviewViewModel;

import java.util.List;

public interface ReviewService {

    ReviewViewModel create(ReviewDto reviewDto);

    List<ReviewViewModel> findAllByProductId(long id);

    List<ReviewByUserViewModel> findAllByUsername(String name);
}
