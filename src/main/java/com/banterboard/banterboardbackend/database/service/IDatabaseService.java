package com.banterboard.banterboardbackend.database.service;

import com.banterboard.banterboardbackend.model.Banter;

import java.util.List;

public interface IDatabaseService {
    public List<Banter> getAllBanters();
}
