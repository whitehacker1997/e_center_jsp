package com.example.e_center_project.data_layer.info.country;

import com.example.e_center_project.core.models.IHaveIdProp;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

public class UpdateCountryDlDto
        extends CountryDlDto implements IHaveIdProp<Integer> {

    @NotNull
    @Getter
    @Setter
    public Integer id;

    @NotNull
    @Getter @Setter
    public Integer stateId;
}
