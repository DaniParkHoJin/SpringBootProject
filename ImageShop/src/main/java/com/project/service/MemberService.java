package com.project.service;

import com.project.domain.Member;
import com.project.domain.MemberAuth;

import java.util.List;

public interface MemberService {

    // Create
    public void create(Member member) throws Exception;

    // Read
    public List<Member> list() throws Exception;
    // 상세 페이지
    public Member read(int userNo) throws Exception;
    // Update
    public void update(Member member) throws Exception;
    // delete
    public void delete(int userNo) throws Exception;
    // 회원 테이블의 데이터 건수를 반환한다.
    public int countAll() throws Exception;
    // 최초 관리자 생성을 위한 데이터를 등록한다.
    public void setupAdmin(Member member) throws Exception;

    // 회원 코인을 반환한다.
    public int getCoin(int userNo) throws Exception;
}
