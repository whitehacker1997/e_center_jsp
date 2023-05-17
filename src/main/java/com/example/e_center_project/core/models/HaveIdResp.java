package com.example.e_center_project.core.models;

import com.example.e_center_project.core.models.HaveId;

public class HaveIdResp<TId> {
    public HaveId<TId> Create(TId id)
    {
        return new HaveId<TId>(id);
    }
}
