package com.project.service;

import com.project.domain.CodeDetail;

import java.util.List;

public interface CodeDetailService {

    //create
    public void register(CodeDetail codeDetail)throws Exception;

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
