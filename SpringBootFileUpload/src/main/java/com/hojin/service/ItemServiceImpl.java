package com.hojin.service;

import com.hojin.domain.Item;
import com.hojin.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper mapper;

    @Override
    public void regist(Item item) throws Exception {
        mapper.create(item);
    }

    @Override
    public Item read(Integer itemId) throws Exception {
        return mapper.read(itemId);
    }

    @Override
    public void modify(Item item) throws Exception {
        mapper.update(item);
    }

    @Override
    public void remove(Integer itemId) throws Exception {
        mapper.delete(itemId);
    }

    @Override
    public List<Item> list() throws Exception {
        return mapper.list();
    }

    @Override
    public String getPicture(Integer itemId) throws Exception {
        return mapper.getPicture(itemId);
    }
}
