package com.travelagency.interfaces;

import com.travelagency.models.viewModels.ReviewViewModel;

import java.util.Set;

public interface Reviewable {

    Set<ReviewViewModel> getReviews();
}
