package id.com.service.mh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class AreaController {
    final RestTemplate restTemplate;

    @Autowired
    public AreaController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/provinces.json")
    public String getAllProvince(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://www.emsifa.com/api-wilayah-indonesia/api/provinces.json", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping("/province/{provId}.json")
    public String getProvince(@PathVariable String provId){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://www.emsifa.com/api-wilayah-indonesia/api/province/" + provId +".json", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping("/regencies/{provId}.json")
    public String getRegencies(@PathVariable String provId){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://www.emsifa.com/api-wilayah-indonesia/api/regencies/" + provId +".json", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping("/regency/{cityId}.json")
    public String getRegency(@PathVariable String cityId){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://www.emsifa.com/api-wilayah-indonesia/api/regency/" + cityId +".json", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping("/districts/{cityId}.json")
    public String getDistricts(@PathVariable String cityId){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://www.emsifa.com/api-wilayah-indonesia/api/districts/" + cityId +".json", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping("/district/{districtId}.json")
    public String getDistrict(@PathVariable String districtId){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://www.emsifa.com/api-wilayah-indonesia/api/district/" + districtId +".json", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping("/villages/{districtId}.json")
    public String getVillages(@PathVariable String districtId){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://www.emsifa.com/api-wilayah-indonesia/api/villages/" + districtId +".json", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping("/village/{wardId}.json")
    public String getVillage(@PathVariable String wardId){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://www.emsifa.com/api-wilayah-indonesia/api/village/" + wardId +".json", HttpMethod.GET, entity, String.class).getBody();
    }
}
