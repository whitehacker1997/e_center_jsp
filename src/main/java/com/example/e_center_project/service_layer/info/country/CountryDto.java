package com.example.e_center_project.service_layer.info.country;

import com.example.e_center_project.core.ILinkToEntity;
import com.example.e_center_project.data_layer.entity_classes.Country;
import com.example.e_center_project.data_layer.info.country.UpdateCountryDlDto;

public class CountryDto
        extends UpdateCountryDlDto
        implements ILinkToEntity<CountryDto, Country> {
}
