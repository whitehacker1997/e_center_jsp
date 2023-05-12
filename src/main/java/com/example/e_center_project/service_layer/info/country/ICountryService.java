package com.example.e_center_project.service_layer.info.country;

import com.example.e_center_project.data_layer.entity_classes.Country;

import java.util.List;

public interface ICountryService {
    List<CountryDto> getCountryList();
    CountryDto getCountry();
    CountryDto getCountryById(Integer id);
    Integer createCountry(Country country);
    void updateCountry(Country country);
    void deleteCountry(Integer id);

}
