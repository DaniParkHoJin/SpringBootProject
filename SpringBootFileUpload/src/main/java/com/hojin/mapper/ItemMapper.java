package com.hojin.mapper;

import com.hojin.domain.Item;

import java.util.List;

public interface ItemMapper {
    public void create(Item item) throws Exception;
    public Item read(Integer itemId) throws Exception;
    public void update(Item item) throws Exception;
    public void delete(Integer itemId) throws Exception;
    public List<Item> list() throws Exception;
    public String getPicture(Integer itemId) throws Exception;
}
