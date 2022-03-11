package com.sitesure.service;

import com.sitesure.model.CovidData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.apache.tomcat.jni.Local;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GetData {
    private static String urlForData ="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
   // private static String urlForData="https://github.com/CSSEGISandData/COVID-19/blob/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
   //private static String urlForData ="https://github.com/CSSEGISandData/COVID-19/blob/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";

    public static List<CovidData> covidDataList = new ArrayList<>();

    public List<CovidData> getCovidDataList() {
        return covidDataList;
    }

    @PostConstruct
    @Scheduled(fixedRate = 60000)
    public void getCovidData(){

        covidDataList.clear();
            try {

                URL url = new URL(urlForData);

                CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase();

                CSVParser csvParser = CSVParser.parse(url, StandardCharsets.UTF_8, csvFormat);
                int idx = 1;
                for (CSVRecord csvRecord : csvParser) {

                    CovidData covidData_ = new CovidData();
                    covidData_.setId(idx);
                    String statedata = csvRecord.get("Province/State");
                    covidData_.setState(statedata.isEmpty() ? "NA" : statedata);
                    covidData_.setCountry(csvRecord.get("Country/Region"));
                    int totalCases = Integer.parseInt(csvRecord.get(csvRecord.size() - 1));
                    int newCases = totalCases - Integer.parseInt(csvRecord.get(csvRecord.size() - 2));
                    covidData_.setTotalCases(totalCases);
                    covidData_.setNewCases(newCases);
                    System.out.println(covidData_);
                    covidDataList.add(covidData_);

                    idx++;
                }
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception e) {
                System.out.println(e);
            }

    }
}
