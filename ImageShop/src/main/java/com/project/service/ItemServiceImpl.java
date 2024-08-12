package com.project.service;

import com.project.domain.Item;
import com.project.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper mapper;

    // 상품 등록
    @Override
    public void register(Item item) throws Exception {
        mapper.create(item);
    }

    // 상품 상세 정보
    @Override
    public Item read(Integer itemId) throws Exception {
        return mapper.read(itemId);
    }

    // 상품 수정
    @Override
    public void modify(Item item) throws Exception {
     mapper.update(item);
    }

    // 상품 제거
    @Override
    public void remove(Integer itemId) throws Exception {
        mapper.delete(itemId);
    }

    // 상품 목록 페이지
    @Override
    public List<Item> list() throws Exception {
        return mapper.list();
    }

    // 미리보기 이미지 표시
    @Override
    public String getPreview(Integer itemId) throws Exception {
        return mapper.getPreview(itemId);
    }

    // 원본 이미지 표시
    @Override
    public String getPicture(Integer itemId) throws Exception {
        return mapper.getPicture(itemId);
    }
}
