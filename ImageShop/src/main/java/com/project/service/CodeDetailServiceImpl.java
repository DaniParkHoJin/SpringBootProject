package com.project.service;

import com.project.domain.CodeDetail;
import com.project.mapper.CodeDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CodeDetailServiceImpl implements CodeDetailService {

    @Autowired
    private CodeDetailMapper mapper;



    //등록처리
    @Override
    public void register(CodeDetail codeDetail) throws Exception {
        String groupCode = codeDetail.getGroupCode();
        int maxSortSeq = mapper.getMaxSortSeq(groupCode);
        codeDetail.setSortSeq(maxSortSeq + 1);
        mapper.create(codeDetail);
    }

    @Override
    @Transactional(readOnly = true)
    public CodeDetail read(CodeDetail codeDetail) throws Exception {
        return mapper.read(codeDetail);
    }

    @Override
    public void update(CodeDetail codeDetail) throws Exception {
        mapper.update(codeDetail);
    }

    @Override
    public void delete(CodeDetail codeDetail) throws Exception {
        mapper.delete(codeDetail);
    }

    //목록 페이지
    @Override
    @Transactional(readOnly = true)
    public List<CodeDetail> list() throws Exception {
        return mapper.list();
    }

    @Override
    @Transactional(readOnly = true)
    public Integer getMaxSortSeq(String groupCode) throws Exception {
        return mapper.getMaxSortSeq(groupCode);
    }
}
