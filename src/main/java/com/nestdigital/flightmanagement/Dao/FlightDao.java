package com.nestdigital.flightmanagement.Dao;

import com.nestdigital.flightmanagement.Model.FlightModel;
import org.springframework.data.repository.CrudRepository;

public interface FlightDao extends CrudRepository<FlightModel,Integer>{
}
