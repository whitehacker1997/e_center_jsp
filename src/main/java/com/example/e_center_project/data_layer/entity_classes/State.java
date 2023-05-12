package com.example.e_center_project.data_layer.entity_classes;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "enum_state")
public class State {

    @Id
    @NonNull
    @Getter @Setter
    public Integer id;

    @Getter @Setter
    public String orderCode;

    @NonNull
    @Getter @Setter
    public String shortName;
    public LocalDate createdAt;

    @OneToMany(mappedBy = "state",cascade = CascadeType.ALL,orphanRemoval = true)
    public List<Country> countries;
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = LocalDate.now();
    }

}
