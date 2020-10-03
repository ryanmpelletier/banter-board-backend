package com.banterboard.banterboardbackend.database.service;

import com.banterboard.banterboardbackend.model.Banter;

import java.util.List;

public interface IDatabaseService {
    public List<Banter> getAllBanters();

    public List<Banter> getTopNLikedBanters(int n);

    public void likeBanter(String userId, String banterId);

    public void deleteBanter(String userId, String banterId);

    public void createBanter(Banter banter);
}
