package com.example.e_center_project.service_layer.info.country;

import com.example.e_center_project.core.models.ILinkToEntity;
import com.example.e_center_project.data_layer.entity_classes.Country;
import com.example.e_center_project.data_layer.info.country.UpdateCountryDlDto;
import lombok.Getter;
import lombok.Setter;

public class CountryDto
        extends UpdateCountryDlDto
        implements ILinkToEntity<CountryDto, Country> {

    @Getter
    @Setter
    public String stateName;
}
