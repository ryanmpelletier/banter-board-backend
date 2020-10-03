package com.banterboard.banterboardbackend.database.service;

import com.banterboard.banterboardbackend.model.Banter;
import com.banterboard.banterboardbackend.model.LikeInfo;
import com.banterboard.banterboardbackend.model.builder.BanterBuilder;
import com.banterboard.banterboardbackend.model.builder.LikeInfoBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DatabaseService implements IDatabaseService {

    private Map<String, Banter> banterDb = new HashMap<String, Banter>();

    @Override
    public List<Banter> getAllBanters() {
        BanterBuilder builder = new BanterBuilder();
        // create a deep copy of the database
        List<Banter> clonedBanters = banterDb.values().parallelStream()//
                .map(banter -> builder.cloneBanter(banter))//
                .collect(Collectors.toList());
        return clonedBanters;
    }

    @Override
    public List<Banter> getTopNLikedBanters(int n) {
        List<Banter> allBanters = getAllBanters();

        // sort by count
        allBanters.sort((a, b) -> {
            int aLikeCount = a.getUserIdToLikeInfoMap().size();
            int bLikeCount = b.getUserIdToLikeInfoMap().size();
            // descending sort
            return Integer.compare(bLikeCount, aLikeCount);
        });

        // get top N liked banters
        // TODO CTG could be a better way to do this
        int maxIndex = n - 1;
        if (allBanters.size() < n) {
            maxIndex = allBanters.size() - 1;
        }
        List<Banter> topNLikedBanters = allBanters.subList(0, maxIndex);

        return topNLikedBanters;
    }

    @Override
    public void likeBanter(String userId, String banterId) {
        Banter foundBanter = getBanter(banterId);
        if (foundBanter != null) {
            Banter clonedBanter = new BanterBuilder().cloneBanter(foundBanter);
            LikeInfo prevLikeInfo = clonedBanter.getUserIdToLikeInfoMap().get(userId);
            if (prevLikeInfo == null) {
                LikeInfo createdLikeInfo = new LikeInfoBuilder().createLikeInfo();
                createdLikeInfo.setLikedBy(userId);
                clonedBanter.getUserIdToLikeInfoMap().put(userId, createdLikeInfo);
            }
            banterDb.put(banterId, foundBanter);
        }
    }

    @Override
    public void deleteBanter(String userId, String banterId) {
        banterDb.remove(banterId);
    }

    @Override
    public void createBanter(Banter banter) {
        banterDb.put(banter.getId(), banter);
    }

    private Banter getBanter(String banterId) {
        return banterDb.get(banterId);
    }


}
