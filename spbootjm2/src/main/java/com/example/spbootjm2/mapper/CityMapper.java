package com.example.spbootjm2.mapper;

import org.apache.ibatis.annotations.Param;

import com.example.spbootjm2.domain.City;

public interface CityMapper {

	/**
	 * 根据城市名称，查询城市信息
	 *
	 * @param cityName
	 *            城市名
	 */
	City findByName(@Param("cityName") String cityName);
}
