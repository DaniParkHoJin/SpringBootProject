package com.project.service;

import com.project.domain.ChargeCoin;
import com.project.domain.PayCoin;
import com.project.mapper.CoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinServiceImpl implements CoinService {

    @Autowired
    private CoinMapper mapper;
    // 코인 충전 처리
    @Override
    public void charge(ChargeCoin chargeCoin) throws Exception {
    mapper.charge(chargeCoin);
    mapper.create(chargeCoin); // 코인 충전 내역 등록
    }
    // 코인 내역 페이지
    @Override
    public List<ChargeCoin> list(int userNo) throws Exception {
        return mapper.list(userNo);
    }
    // 회원 상품 구매 내역을 반환한다.
    @Override
    public List<PayCoin> listPayHistory(int userNo) throws Exception {

        return mapper.listPayHistory(userNo);
    }
}
