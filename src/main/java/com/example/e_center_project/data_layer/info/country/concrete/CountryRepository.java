package com.example.e_center_project.data_layer.info.country.concrete;

import com.example.e_center_project.core.services.BaseEntityRepository;
import com.example.e_center_project.core.interfaces.IEntityMapper;
import com.example.e_center_project.core.constants.StateIdConst;
import com.example.e_center_project.data_layer.entity_classes.Country;
import com.example.e_center_project.data_layer.info.country.CountryDlDto;
import com.example.e_center_project.data_layer.info.country.CountryJpaRepository;
import com.example.e_center_project.data_layer.info.country.CreateCountryDlDto;
import com.example.e_center_project.data_layer.info.country.UpdateCountryDlDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CountryRepository
        extends BaseEntityRepository<Integer, Country, Country, CountryDlDto, CreateCountryDlDto, UpdateCountryDlDto, JpaRepository<Country, Integer>>
        implements ICountryRepository {
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public CountryRepository(IEntityMapper entityMapper,
                             CountryJpaRepository repository) {
        super(entityMapper, repository);
    }

    @Override
    public Optional<Country> GetCountryByCode(String code) {
        return Optional.empty();
    }

    @Override
    public Country onCreate(Country entity) {
        entity.setStateId(StateIdConst.ACTIVE);
        entity.setFullName(entity.getShortName());
        return  entity;
    }
}
