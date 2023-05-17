package com.example.e_center_project.service_layer.info.country;

import com.example.e_center_project.core.models.HaveId;
import com.example.e_center_project.data_layer.info.country.CreateCountryDlDto;
import com.example.e_center_project.data_layer.info.country.UpdateCountryDlDto;

import java.util.stream.Stream;

public interface ICountryService {
    Stream<CountryDto> getCountryList();

    CountryDto getCountry();

    CountryDto getCountryById(Integer id);

    HaveId<Integer> createCountry(CreateCountryDlDto country);

    void updateCountry(UpdateCountryDlDto country);

    void deleteCountry(Integer id);

}
