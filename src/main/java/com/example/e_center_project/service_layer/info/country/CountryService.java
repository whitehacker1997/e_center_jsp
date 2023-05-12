package com.example.e_center_project.service_layer.info.country;

import com.example.e_center_project.core.IEntityMapper;
import com.example.e_center_project.data_layer.entity_classes.Country;
import com.example.e_center_project.data_layer.info.country.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CountryService
        implements ICountryService {
    private final ICountryRepository countryRepository;
    private final IEntityMapper entityMapper;

    @Autowired
    public CountryService(
            ICountryRepository countryRepository,
            IEntityMapper entityMapper) {
        this.countryRepository = countryRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<CountryDto> getCountryList() {
        List<Country> countryList = countryRepository.findAll();

        return entityMapper.entityListToDtoList(countryList, CountryDto.class);
    }

    @Override
    public CountryDto getCountry() {
        return new CountryDto();
    }

    @Override
    public CountryDto getCountryById(Integer id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("There no country in this id = %d".formatted(id)));

        return entityMapper.entityToDto(country, CountryDto.class);
    }

    @Override
    public Integer createCountry(Country country) {
        Optional<Country> oldCountry
                = countryRepository.GetCountryByCode(country.getCode());

        if (oldCountry.isPresent())
            throw new IllegalStateException("There is already county with this code %s".formatted(country.code));

        var entity = countryRepository.save(country);

        return entity.id;
    }

    @Override
    @Transactional
    public void updateCountry(Country country) {
        Country existingCountry
                = countryRepository.findById(country.id)
                .orElseThrow(() -> {
                    return new IllegalStateException("Student with id = %d does not exists".formatted(country.id));
                });

        existingCountry.setCode(country.code);
        existingCountry.setFullName(country.fullName);
        existingCountry.setOrderCode(country.orderCode);
        existingCountry.setStateId(country.stateId);
    }

    @Override
    public void deleteCountry(Integer id) {
        boolean exists = countryRepository.existsById(id);

        if (!exists)
            throw new IllegalStateException("Country id = %d does not exists".formatted(id));

        countryRepository.deleteById(id);
    }
}
