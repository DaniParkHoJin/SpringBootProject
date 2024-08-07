package com.project.mapper;

import com.project.domain.CodeGroup;

import java.util.List;

public interface CodeGroupMapper {
    // 등록 처리
    public void create(CodeGroup codeGroup) throws Exception;

    // 목록 페이지
    public List<CodeGroup> list() throws Exception;

    // 상세 페이지 (수정 페이지도 함께 사용)
    public CodeGroup read(String codeGroup) throws Exception;

    // 수정 처리
    public void update(CodeGroup codeGroup) throws Exception;

    // 살제 처리
    public void delete(String groupCode) throws Exception;
}
