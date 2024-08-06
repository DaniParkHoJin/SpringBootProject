package com.project.service;

import com.project.domain.CodeGroup;
import com.project.mapper.CodeGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupServiceImpl implements CodeGroupService {

    @Autowired
    private CodeGroupMapper mapper;

    // 등록처리
    @Override
    public void register(CodeGroup codeGroup) throws Exception{
        mapper.create(codeGroup);
    }
}
