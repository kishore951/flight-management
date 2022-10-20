package com.nestdigital.flightmanagement.Controller;

import com.nestdigital.flightmanagement.Dao.FlightDao;
import com.nestdigital.flightmanagement.Model.FlightModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightDao dao;



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/flightAdd",consumes = "application/json",produces = "application/json")
    public String flight(@RequestBody FlightModel flight){
        dao.save(flight);
        return "{status:'success}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewFlights")
    public List<FlightModel> viewFlights(){
        return (List<FlightModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deleteFlight",consumes = "application/json",produces = "application/json")
    public String deleteFlight(@RequestBody FlightModel flight){
        dao.deleteFlightById((flight.getId()));
        return "{status:'success}";
    }


    @CrossOrigin(origins = "*")
    @PostMapping(value = "/searchFlight",consumes = "application/json",produces = "application/json")
    public List<FlightModel> searchFlight(@RequestBody FlightModel flight){
        return (List<FlightModel>) dao.searchFlight(flight.getName());
    }
}
