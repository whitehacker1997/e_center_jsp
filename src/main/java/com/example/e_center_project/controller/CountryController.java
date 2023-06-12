package com.example.e_center_project.controller;

import com.example.e_center_project.core.models.HaveId;
import com.example.e_center_project.data_layer.info.country.CreateCountryDlDto;
import com.example.e_center_project.data_layer.info.country.UpdateCountryDlDto;
import com.example.e_center_project.service_layer.info.country.CountryDto;
import com.example.e_center_project.service_layer.info.country.concrete.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(name = "/country")
public class CountryController {

    private final ICountryService countryService;

    @Autowired
    public CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/getCountryList")
    public ResponseEntity<Stream<CountryDto>> getCountryList() {
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
    public ResponseEntity<HaveId<Integer>> createCountry(@RequestBody CreateCountryDlDto country) {
        return ResponseEntity.ok(countryService.createCountry(country));
    }

    @PutMapping("/updateCountry")
    public ResponseEntity<Integer> updateCountry(@RequestBody UpdateCountryDlDto country) {
        countryService.updateCountry(country);
        return ResponseEntity.ok(country.getId());
    }

    @DeleteMapping("/deleteCountry/{id}")
    public void deleteCountry(@PathVariable("id") Integer id) {
        countryService.deleteCountry(id);
    }
}
