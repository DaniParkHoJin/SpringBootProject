package com.project.service;

import com.project.domain.CodeGroup;
import com.project.mapper.CodeGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeGroupServiceImpl implements CodeGroupService {

    @Autowired
    private CodeGroupMapper mapper;

    // 등록처리
    @Override
    public void register(CodeGroup codeGroup) throws Exception {
        mapper.create(codeGroup);
    }

    // 목록 페이지
    @Override
    public List<CodeGroup> list() throws Exception {
        return mapper.list();
    }

    // 상세 페이지 (수정 페이지도 함께 사용)
    @Override
    public CodeGroup read(String groupCode) throws Exception {
        return mapper.read(groupCode);
    }
    // 수정 처리
    @Override
    public void modify(CodeGroup codeGroup) throws Exception {
        mapper.update(codeGroup);
    }
    // 삭제 처리
    @Override
    public void remove(String groupCode) throws Exception {
     mapper.delete(groupCode);
    }
}
