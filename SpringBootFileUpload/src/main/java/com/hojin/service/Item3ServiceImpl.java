package com.hojin.service;

import com.hojin.domain.Item3;
import com.hojin.mapper.Item3Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class Item3ServiceImpl implements Item3Service {

    @Autowired
    private Item3Mapper mapper3;

    @Transactional
    @Override
    public void regist(Item3 item3) throws Exception {
        mapper3.create(item3);
        log.info("item3.getFiles() : " + item3.toString());
        String[] files = item3.getFiles();
        if (files == null) {
            return;
        }
        for (String fileName : files) {
            mapper3.addAttach(fileName);
        }
    }

    @Override
    public Item3 read(Integer itemId) throws Exception {
        return mapper3.read(itemId);
    }

    @Transactional
    @Override
    public void modify(Item3 item3) throws Exception {
        mapper3.update(item3);
        Integer itemId = item3.getItemId();
        mapper3.deleteAttach(itemId);
        String[] files = item3.getFiles();
        if (files == null) {
            return;
        }
        for (String fileName : files) {
            mapper3.replaceAttach(fileName, itemId);
        }
    }

    @Transactional
    @Override
    public void remove(Integer itemId) throws Exception {
        mapper3.deleteAttach(itemId);
        mapper3.delete(itemId);
    }

    @Override
    public List<Item3> list() throws Exception {
        return mapper3.list();
    }

    @Override
    public List<String> getAttach(Integer itemId) throws Exception {
        return mapper3.getAttach(itemId);
    }
}