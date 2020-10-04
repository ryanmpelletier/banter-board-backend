package com.banterboard.banterboardbackend.database.service;

import com.banterboard.banterboardbackend.model.Banter;

import java.util.List;

/**
 * Basic CRUD interface for working with Banters
 */
public interface IDatabaseService {

    /**
     * Create
     */
    void createBanter(Banter banter);

    /**
     * Read
     */
    List<Banter> getAllBanters();
    Banter getBanter(String id);
    List<Banter> getTopNLikedBanters(int n);

    /**
     * Update
     */
    void updateBanter(Banter banter);
    void likeBanter(String userId, String banterId);

    /**
     * Delete
     */
    void deleteBanter(String banterId);


}
