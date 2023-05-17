package com.example.e_center_project.data_layer;

import com.example.e_center_project.data_layer.entity_classes.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultDataLoader implements CommandLineRunner {

    private final JpaRepository repository;

    @Autowired
    public DefaultDataLoader(JpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*ArrayList<State> stateList = new ArrayList<State>();
        State state = new State();
        state.setId(1);
        state.setOrderCode("001");
        state.setShortName("Active");
        state.setCreatedAt(LocalDate.now());
        stateList.add(state);

        State state1 = new State();

        state1.setId(2);
        state1.setOrderCode("002");
        state1.setShortName("Passive");
        state1.setCreatedAt(LocalDate.now());
        stateList.add(state1);

        repository.saveAll(stateList);*/
    }
}
