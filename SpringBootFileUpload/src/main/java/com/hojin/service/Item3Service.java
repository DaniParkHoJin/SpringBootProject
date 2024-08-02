package com.hojin.service;

import com.hojin.domain.Item3;
import com.hojin.mapper.Item3Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Item3Service {
    public void regist(Item3 item3) throws Exception;

    public Item3 read(Integer itemId) throws Exception;

    public void modify(Item3 item3) throws Exception;

    public void remove(Integer itemId) throws Exception;

    public List<Item3> list() throws Exception;

    public List<String> getAttach(Integer itemId) throws Exception;

}
