package com.example.e_center_project.core.models;

public class HaveId<TId>
        implements IHaveIdProp<TId> {
    public TId id;

    public HaveId(TId id) {
        this.id = id;
    }

    @Override
    public TId getId() {
        return this.id;
    }
}
