package com.example.e_center_project.data_layer.info.country;

import com.example.e_center_project.data_layer.entity_classes.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryJpaRepository extends JpaRepository<Country, Integer> {
}
