package com.example.e_center_project.service_layer.info.country;

import com.example.e_center_project.core.HaveId;
import com.example.e_center_project.core.HaveIdResp;
import com.example.e_center_project.data_layer.entity_classes.Country;
import com.example.e_center_project.data_layer.info.country.CreateCountryDlDto;

import java.util.List;
import java.util.stream.Stream;

public interface ICountryService {
    Stream<CountryDto> getCountryList();
    CountryDto getCountry();
    CountryDto getCountryById(Integer id);
    HaveId<Integer> createCountry(CreateCountryDlDto country);
    void updateCountry(Country country);
    void deleteCountry(Integer id);

}
