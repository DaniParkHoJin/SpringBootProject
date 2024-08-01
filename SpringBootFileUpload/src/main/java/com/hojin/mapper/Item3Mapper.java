package com.hojin.mapper;

import com.hojin.domain.Item3;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Item3Mapper {
    public void create(Item3 item3) throws Exception;

    public Item3 read(Integer itemId) throws Exception;

    public void update(Item3 item3) throws Exception;

    public void delete(Integer itemId) throws Exception;

    public List<Item3> list() throws Exception;

    public void addAttach(String fullName) throws Exception;

    public List<String> getAttach(Integer itemId) throws Exception;

    public void deleteAttach(Integer itemId) throws Exception;

    public void replaceAttach(@Param("fullName") String fullName, @Param("itemId")
    Integer itemId) throws Exception;
}
