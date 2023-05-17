package com.example.e_center_project.data_layer.info.country;

import com.example.e_center_project.core.models.EntityDto;
import com.example.e_center_project.data_layer.entity_classes.Country;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;

public class CountryDlDto
        extends EntityDto<CountryDlDto, Country> {

    @Nullable
    @Getter
    @Setter
    public String orderCode;

    @NotNull
    @Getter
    @Setter
    public String code;

    @NotNull
    @Getter
    @Setter
    public String shortName;
}
