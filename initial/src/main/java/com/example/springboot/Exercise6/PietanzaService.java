package com.example.springboot.Exercise6;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PietanzaService {
    private PietanzaDao pietanzaDao;
    @Autowired
    public PietanzaService(PietanzaDao pietanzaDao) {
        this.pietanzaDao = pietanzaDao;
    }

    public List<Pietanza> getPietanze() {
        return pietanzaDao.findAll();
    }
    public List<Pietanza> pietanza1() {
        return pietanzaDao.findByDescription("Lenticchie");
    }
    public List<Pietanza> pietanza2() {
        return pietanzaDao.findByPriceLessThan(13.0);
    }
    public List<Pietanza> pietanza3() {
        return pietanzaDao.findByPriceBetween(11.0, 15.0);
    }
    public List<Pietanza> pietanza4() {
        return pietanzaDao.findByDescriptionAndPriceLessThan("Pasta al pomodoro", 11.0);
    }
    public List<Pietanza> pietanza5() {
        return pietanzaDao.findByDescriptionContains("pomodoro");
    }
    public List<Pietanza> pietanza6() {
        return pietanzaDao.findByPriceLessThanAndCaloriesGreaterThanOrCaloriesLessThan(11.0, 500, 100);
    }

    public List<Pietanza> getWinterPietanze() {
        Double currentTemp = getCurrentTemperatureInCelsius();
        if (currentTemp < 12.0) {
            return pietanzaDao.findByIsWinterMeal(true);
        } else return pietanzaDao.findByIsWinterMeal(false);
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
