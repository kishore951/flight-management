package com.nestdigital.flightmanagement.Dao;

import com.nestdigital.flightmanagement.Model.FlightModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightDao extends CrudRepository<FlightModel,Integer>{

    @Modifying
    @Query(value = "DELETE FROM `flights` WHERE `id`=:id",nativeQuery = true)
    void deleteFlightById(Integer id);


    @Query(value ="SELECT `id`, `capacity`, `destination`, `name`, `origin` FROM `flights` WHERE `name`=:name",nativeQuery = true)
    List<FlightModel> searchFlight(String name);
}
