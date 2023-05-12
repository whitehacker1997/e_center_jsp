package com.example.e_center_project.data_layer.entity_classes;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "info_country")
public class Country {
    public Country() {
    }

    @Id
    @NonNull
    @SequenceGenerator(name = "country_sequence",sequenceName = "country_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "country_sequence")
    public Integer id;

    @Nullable
    @Getter @Setter
    public String orderCode;

    @NonNull
    @Getter @Setter
    public String code;

    @NonNull
    @Getter @Setter
    public String fullName;

    @NonNull
    @Getter @Setter
    public String shortName;

    @NonNull
    @Getter @Setter
    @Column(name = "state_id")
    public Integer stateId;

    @NonNull
    @Getter @Setter
    public LocalDate createdAt;

    @Getter @Setter
    public Integer createdBy;

    @Getter @Setter
    public LocalDate modifiedAt;

    @Getter @Setter
    public Integer modifiedBy;

    @ManyToOne
    @JoinColumn(name = "state_id",referencedColumnName = "id",insertable = false,updatable = false)
    public State state;
}
