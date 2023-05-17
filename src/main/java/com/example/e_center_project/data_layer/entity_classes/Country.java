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
    @SequenceGenerator(name = "country_sequence", sequenceName = "country_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_sequence")
    private Integer id;

    @Nullable
    @Getter @Setter
    private String orderCode;

    @NotNull
    @Getter @Setter
    private String code;

    @NotNull
    @Getter @Setter
    private String fullName;

    @NotNull
    @Getter @Setter
    private String shortName;

    @NotNull
    @Getter @Setter
    private LocalDate createdAt;

    @Getter @Setter
    private Integer createdBy;

    @Getter @Setter
    private LocalDate modifiedAt;

    @Getter @Setter
    private Integer modifiedBy;

    @NotNull
    @Column(name = "state_id")
    @Setter
    private Integer stateId;

    @ManyToOne
    @Getter
    @JoinColumn(name = "state_id", referencedColumnName = "id", insertable = false, updatable = false)
    private State state;
}
