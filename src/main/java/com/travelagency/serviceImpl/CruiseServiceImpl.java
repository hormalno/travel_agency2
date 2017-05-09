package com.travelagency.serviceImpl;

import com.travelagency.entities.City;
import com.travelagency.entities.Cruise;
import com.travelagency.models.bindingModels.CruiseDto;
import com.travelagency.models.viewModels.CruiseDetailViewModel;
import com.travelagency.models.viewModels.CruiseViewModel;
import com.travelagency.repositories.CityRepository;
import com.travelagency.repositories.CruiseRepository;
import com.travelagency.services.CruiseService;
import org.modelmapper.*;
import org.modelmapper.spi.Mapping;
import org.modelmapper.spi.PropertyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CruiseServiceImpl implements CruiseService {

    private final CruiseRepository cruiseRepository;

    private final ModelMapper modelMapper;

    private final CityRepository cityRepository;

    @Autowired
    public CruiseServiceImpl(CruiseRepository cruiseRepository, ModelMapper modelMapper, CityRepository cityRepository) {
        this.cruiseRepository = cruiseRepository;
        this.modelMapper = modelMapper;
        this.cityRepository = cityRepository;
    }

    @Override
    public void create(CruiseDto cruiseDto) {
        Cruise cruise = this.modelMapper.map(cruiseDto, Cruise.class);
        City origin = this.cityRepository.findByName(cruiseDto.getOriginName());
        cruise.setOrigin(origin);
        for (String destinationCityName : cruiseDto.getDestinationNames()) {
            City destination = this.cityRepository.findByName(destinationCityName);
            cruise.getDestinations().add(destination);
        }
        this.cruiseRepository.saveAndFlush(cruise);
    }

    @Override
    public CruiseDetailViewModel findById(long id) {
        Cruise cruise = this.cruiseRepository.findOne(id);
        return this.modelMapper.map(cruise,CruiseDetailViewModel.class);
    }

    @Override
    public Page<CruiseViewModel> findAll(Pageable pageable) {
        List<CruiseViewModel> cruiseViewModels = new ArrayList<>();
        Page<Cruise> cruises = this.cruiseRepository.findAll(pageable);
        for (Cruise cruise : cruises) {
            CruiseViewModel cruiseViewModel = this.modelMapper.map(cruise,CruiseViewModel.class);
            cruiseViewModels.add(cruiseViewModel);
        }
        return new PageImpl<>(cruiseViewModels,pageable,cruises.getTotalElements());
    }
}
