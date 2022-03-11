package com.sitesure.controller;

import com.sitesure.model.CovidData;
import com.sitesure.service.GetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    GetData covidDataFromCSV;


    @GetMapping("/")
    public String home(Model model)
    {
        GetData getData = new GetData();
        List<CovidData> covidDataList = getData.getCovidDataList();

        int totalCasesInWorld = covidDataList.stream().mapToInt(covidData->covidData.getTotalCases()).sum();

        model.addAttribute("totalCasesInWorld",totalCasesInWorld);
        model.addAttribute("covidDataList",covidDataList);
        return "home";
    }
}
