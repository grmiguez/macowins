package com.grm.dds.domain.clothe;

import com.grm.dds.domain.clothe.state.ClotheState;

public interface Clothe {

    float getClothePrice();

    float getSalePrice();

    ClotheState state() throws Exception;

}
