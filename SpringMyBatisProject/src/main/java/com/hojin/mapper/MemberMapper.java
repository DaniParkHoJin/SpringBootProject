package com.hojin.mapper;

import com.hojin.domain.Member;
import com.hojin.domain.MemberAuth;

import java.util.List;

public interface MemberMapper {
    public void create(Member member);
    public void createAuth(MemberAuth member);
    // 교안과 달리
    public Member findByMember(String userId);


    public List<Member> list() throws Exception;
    public Member read(int userNo) throws Exception;
    public void update(Member member) throws Exception;
    public void delete(int userNo) throws Exception;
    public void deleteAuth(int userNo) throws Exception;
}
