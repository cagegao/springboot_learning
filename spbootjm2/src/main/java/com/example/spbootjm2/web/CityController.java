package com.example.spbootjm2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spbootjm2.domain.City;
import com.example.spbootjm2.service.CityService;

@RestController
public class CityController {

	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
		return cityService.findCityByName(cityName);
	}
}
