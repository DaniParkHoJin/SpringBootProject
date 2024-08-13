package com.project.mapper;

import com.project.domain.ChargeCoin;
import com.project.domain.PayCoin;

import java.util.List;

public interface CoinMapper {

    // 충전 내역 등록
    public void create(ChargeCoin chargeCoin) throws Exception;
    // 코인 충전
    public void charge(ChargeCoin chargeCoin) throws Exception;
    // 충전 내역 조회
    public List<ChargeCoin> list(Integer userNo) throws Exception;

    // 코인 지급
    public void pay(PayCoin payCoin) throws Exception;
    // 구매 내역 등록
    public void createPayHistory(PayCoin payCoin) throws Exception;
    // 구매 내역 조회
    public List<PayCoin> listPayHistory(int userNo) throws Exception;

}

