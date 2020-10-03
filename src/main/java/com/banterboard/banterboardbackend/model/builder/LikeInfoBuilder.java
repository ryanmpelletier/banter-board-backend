package com.banterboard.banterboardbackend.model.builder;

import com.banterboard.banterboardbackend.model.LikeInfo;

public class LikeInfoBuilder {

    public LikeInfo createLikeInfo() {
        LikeInfo likeInfo = new LikeInfo();
        likeInfo.setLikedBy("");
        return likeInfo;
    }

    public LikeInfo cloneLikeInfo(LikeInfo toBeCloned) {
        LikeInfo likeInfo = new LikeInfo();
        likeInfo.setLikedBy(toBeCloned.getLikedBy());
        return likeInfo;
    }


}
