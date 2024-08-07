package com.project.mapper;

import com.project.domain.CodeDetail;

import java.util.List;

public interface CodeDetailMapper {
    //등록 처리
    public void create(CodeDetail codeDetail) throws Exception;

    //read
    public CodeDetail read(CodeDetail codeDetail)throws Exception;

    //update
    public void update(CodeDetail codeDetail)throws Exception;

    //delete
    public void delete(CodeDetail codeDetail)throws Exception;

    // 목록 페이지
    public List<CodeDetail> list() throws Exception;

    public Integer getMaxSortSeq(String groupCode) throws Exception;

}



