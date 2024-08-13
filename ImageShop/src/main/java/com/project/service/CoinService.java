package com.project.service;

import com.project.domain.ChargeCoin;
import com.project.domain.PayCoin;

import java.util.List;

public interface CoinService {

    // 코인 충전 처리
    public void charge(ChargeCoin chargeCoin) throws Exception;
    // 코인 내역 페이지
    public List<ChargeCoin> list(int userNo) throws Exception;

    // 회원 상품 구매 내역을 반환한다.
    public List<PayCoin> listPayHistory(int userNo) throws Exception;

}
