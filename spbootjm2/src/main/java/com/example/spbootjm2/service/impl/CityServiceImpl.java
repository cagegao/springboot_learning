package com.example.spbootjm2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spbootjm2.domain.City;
import com.example.spbootjm2.mapper.CityMapper;
import com.example.spbootjm2.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
    private CityMapper cityMapper;

    public City findCityByName(String cityName) {
        return cityMapper.findByName(cityName);
    }
}
