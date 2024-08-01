package com.hojin.service;

import com.hojin.domain.Item;
import com.hojin.domain.Item2;
import com.hojin.mapper.Item2Mapper;
import com.hojin.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Item2ServiceImpl implements Item2Service {

    @Autowired
    private Item2Mapper mapper2;

    @Override
    public void regist(Item2 item) throws Exception {
        mapper2.create(item);
    }
    @Override
    public Item2 read(Integer itemId) throws Exception {
        return mapper2.read(itemId);
    }
    @Override
    public void modify(Item2 item) throws Exception {
        mapper2.update(item);
    }
    @Override
    public void remove(Integer itemId) throws Exception {
        mapper2.delete(itemId);
    }
    @Override
    public List<Item2> list() throws Exception {
        return mapper2.list();
    }
    @Override
    public String getPicture(Integer itemId) throws Exception {
        return mapper2.getPicture(itemId);
    }
    @Override
    public String getPicture2(Integer itemId) throws Exception {
        return mapper2.getPicture2(itemId);
    }

}
