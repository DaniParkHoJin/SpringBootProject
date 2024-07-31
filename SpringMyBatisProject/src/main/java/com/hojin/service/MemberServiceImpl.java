package com.hojin.service;

import com.hojin.domain.Member;
import com.hojin.domain.MemberAuth;
import com.hojin.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberMapper mapper;

    @Transactional
    @Override
    public void register(Member member) throws Exception {

        mapper.create(member);
        // 교안과 다르게 시퀀스를 사용하지 않았기 때문에 값을 전달받기 위해서  만든 코드
        Member  findMember = mapper.findByMember(member.getUserId());

        log.info("생성된 사용자:{}",findMember.toString());

        MemberAuth memberAuth = new MemberAuth();

        memberAuth.setUserNo(findMember.getUserNo());
        memberAuth.setAuth("ROLE_USER");

        mapper.createAuth(memberAuth);
    }
    @Override
    public Member read(int userNo) throws Exception {
        return mapper.read(userNo);
    }
    @Transactional
    @Override
    public void modify(Member member) throws Exception {
        mapper.update(member);
        int userNo = member.getUserNo();
        mapper.deleteAuth(userNo);
        List<MemberAuth> authList = member.getAuthList();
        for (int i = 0; i < authList.size(); i++) {
            MemberAuth memberAuth = authList.get(i);
            String auth = memberAuth.getAuth();
            if (auth == null) {
                continue;
            }
            if (auth.trim().length() == 0) {
                continue;
            }
            memberAuth.setUserNo(userNo);
            mapper.createAuth(memberAuth);
        }
    }
    @Transactional
    @Override
    public void remove(int userNo) throws Exception {
        mapper.deleteAuth(userNo);  // 삭제 순서
        mapper.delete(userNo);
    }
    @Override
    public List<Member> list() throws Exception {
        return mapper.list();
    }
}
