package com.project.service;

import com.project.common.domain.CodeLabelValue;
import com.project.mapper.CodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {


    @Autowired
    private CodeMapper mapper;

    // 그룹코드 목록 조회 구현
    @Override
    public List<CodeLabelValue> getCodeGroupList() throws Exception {
        return mapper.getCodeGroupList();
    }
}
