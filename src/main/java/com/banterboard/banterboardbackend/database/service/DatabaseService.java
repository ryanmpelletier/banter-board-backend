package com.banterboard.banterboardbackend.database.service;

import com.banterboard.banterboardbackend.model.Banter;
import com.banterboard.banterboardbackend.model.builder.BanterBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseService implements IDatabaseService {

    @Override
    public List<Banter> getAllBanters() {
        List<Banter> fakeList = new ArrayList<>();
        BanterBuilder build = new BanterBuilder();
        Banter created = build.createBanter();
        fakeList.add(created);
        return fakeList;
    }


}
