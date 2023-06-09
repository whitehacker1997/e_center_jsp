package com.example.e_center_project.controller;

import com.example.e_center_project.data_layer.entity_classes.Country;
import com.example.e_center_project.service_layer.info.country.CountryDto;
import com.example.e_center_project.service_layer.info.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/country")
public class CountryController {

    private final ICountryService countryService;

    @Autowired
    public CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/getCountryList")
    public ResponseEntity<List<CountryDto>> getCountryList() {
        return ResponseEntity.ok(countryService.getCountryList());
    }

    @GetMapping("/getCountry")
    public ResponseEntity<CountryDto> getCountry() {
        return ResponseEntity.ok(countryService.getCountry());
    }

    @GetMapping("/getCountry/{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @PostMapping("/createCountry")
    public ResponseEntity<Integer> createCountry(@RequestBody Country country){
        return ResponseEntity.ok(countryService.createCountry(country));
    }

    @PutMapping("/updateCountry")
    public ResponseEntity<Integer> updateCountry(@RequestBody Country country){
        countryService.updateCountry(country);
        return ResponseEntity.ok(country.id);
    }

    @DeleteMapping("/deleteCountry/{id}")
    public void deleteCountry(@PathVariable("id") Integer id){
        countryService.deleteCountry(id);
    }
}
