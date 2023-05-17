package com.example.e_center_project.data_layer.info.country;

import com.example.e_center_project.core.IBaseEntityRepository;
import com.example.e_center_project.data_layer.entity_classes.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICountryRepository
            extends IBaseEntityRepository<Integer,Country,Country,CountryDlDto,CreateCountryDlDto,UpdateCountryDlDto,JpaRepository<Country,Integer>> {
    @Query("SELECT c FROM Country c WHERE c.code = ?1")
    Optional<Country> GetCountryByCode(String code);
}