package com.example.spbootjm3.repository.cluster;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.spbootjm3.domain.City;

/**
 * 城市 DAO 接口类
 *
 */
@Mapper
public interface CityRepository {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}