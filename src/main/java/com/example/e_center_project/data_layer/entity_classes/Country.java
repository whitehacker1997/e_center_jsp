package com.example.e_center_project.data_layer.entity_classes;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "info_country")
public class Country {
    public Country() {
    }

    @Id
    @NotNull
    @Getter @Setter
    @SequenceGenerator(name = "country_sequence",sequenceName = "country_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "country_sequence")
    public Integer id;

    @Nullable
    @Getter @Setter
    public String orderCode;

    @NotNull
    @Getter @Setter
    public String code;

    @NotNull
    @Getter @Setter
    public String fullName;

    @NotNull
    @Getter @Setter
    public String shortName;

    @NotNull
    @Getter @Setter
    @Column(name = "state_id")
    public Integer stateId;

    @NotNull
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
