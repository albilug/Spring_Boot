package com.example.springboot.Exercise6;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortataService {
    private PortataDao portataDao;
    @Autowired
    public PortataService(PortataDao portataDao) {
        this.portataDao = portataDao;
    }

    public List<Portata> getPortate() {
        return portataDao.findAll();
    }
    public List<Portata> portata1() {
        return portataDao.findByDescription("Lenticchie");
    }
    public List<Portata> portata2() {
        return portataDao.findByPriceLessThan(13.0);
    }
    public List<Portata> portata3() {
        return portataDao.findByPriceBetween(11.0, 15.0);
    }
    public List<Portata> portata4() {
        return portataDao.findByDescriptionAndPriceLessThan("Pasta al pomodoro", 11.0);
    }
    public List<Portata> portata5() {
        return portataDao.findByDescriptionContains("pomodoro");
    }
    public List<Portata> portata6() {
        return portataDao.findByPriceLessThanAndCaloriesGreaterThanOrCaloriesLessThan(11.0, 500, 100);
    }

    public List<Portata> getWinterPortate() {
        Double currentTemp = getCurrentTemperatureInCelsius();
        if (currentTemp < 12.0) {
            return portataDao.findByIsWinterMeal(true);
        } else return portataDao.findByIsWinterMeal(false);
    }

    private Double getCurrentTemperatureInCelsius(){
        JSONObject apiResponse = null;
        try {
            apiResponse = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=64.14&longitude=-21.90&current_weather=true")
                    .asJson().getBody().getObject();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        return apiResponse.getJSONObject("current_weather").getDouble("temperature");
    }
}
