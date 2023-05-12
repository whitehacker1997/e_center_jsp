package com.example.e_center_project.service_layer.info.country;

import lombok.Getter;
import lombok.Setter;

public class CountryDto {
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
