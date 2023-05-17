package com.example.e_center_project.service_layer.info.country;

import com.example.e_center_project.core.*;
import com.example.e_center_project.data_layer.entity_classes.Country;
import com.example.e_center_project.data_layer.info.country.CreateCountryDlDto;
import com.example.e_center_project.data_layer.info.country.ICountryRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CountryService
        implements ICountryService {
    private final ICountryRepository countryRepository;
    private final IEntityMapper entityMapper;
    private final ICrudService<Integer, Country, Country> crudService;

    @Autowired
    public CountryService(
            ICountryRepository countryRepository,
            IEntityMapper entityMapper,
            ICrudService<Integer, Country, Country> crudService) {
        this.countryRepository = countryRepository;
        this.entityMapper = entityMapper;
        this.crudService = crudService;
    }

    @Override
    public Stream<CountryDto> getCountryList() {
        return crudService.projectEntityToDto(CountryDto.class)
                .filter(a -> a.id > 2);
    }

    @Override
    public CountryDto getCountry() {
        return new CountryDto();
    }

    @Override
    public CountryDto getCountryById(Integer id) {
        var result = crudService.readSingle(id, CountryDto.class);

        if (result == null)
            throw new IllegalStateException("There is no item in this id = %d".formatted(id));

        return result;
    }

    @Override
    public HaveId<Integer> createCountry(@NotNull CreateCountryDlDto country) {
        Optional<Country> oldCountry
                = countryRepository.GetCountryByCode(country.getCode());

        if (oldCountry.isPresent())
            throw new IllegalStateException("There is already county with this code %s".formatted(country.code));

        var result = countryRepository.create(Country.class, country);

        if (result == null)
            return null;

        return new HaveIdResp<Integer>().Create(result.id);
    }

    @Override
    @Transactional
    public void updateCountry(Country country) {
        /*Country existingCountry
                = countryRepository.findById(country.id)
                .orElseThrow(() -> {
                    return new IllegalStateException("Student with id = %d does not exists".formatted(country.id));
                });

        existingCountry.setCode(country.code);
        existingCountry.setFullName(country.fullName);
        existingCountry.setOrderCode(country.orderCode);
        existingCountry.setStateId(country.stateId);*/
    }

    @Override
    public void deleteCountry(Integer id) {
        /*boolean exists = countryRepository.existsById(id);

        if (!exists)
            throw new IllegalStateException("Country id = %d does not exists".formatted(id));

        countryRepository.deleteById(id);*/
    }
}
