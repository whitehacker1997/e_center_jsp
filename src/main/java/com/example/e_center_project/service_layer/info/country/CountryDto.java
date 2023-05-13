package com.example.e_center_project.service_layer.info.country;

import com.example.e_center_project.core.EntityDto;
import com.example.e_center_project.data_layer.entity_classes.Country;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

public class CountryDto
        extends EntityDto<Country>
{
    @Getter
    @Setter
    public Integer id;
    @Getter
    @Setter
    public String orderCode;
    @Getter
    @Setter
    public String code;
    @Getter
    @Setter
    public String fullName;
    @Getter
    @Setter
    public String shortName;
    @Getter
    @Setter
    public Integer stateId;
}
