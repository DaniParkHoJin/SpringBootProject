package com.project.service;

import com.project.common.domain.CodeLabelValue;

import java.util.List;

public interface CodeService {

    // 그룹코드 목록 조회
    public List<CodeLabelValue> getCodeGroupList() throws Exception;
}