package com.project.mapper;

import com.project.domain.Member;
import com.project.domain.MemberAuth;

import java.util.List;

public interface MemberMapper {
    // create
    public void create(Member member) throws Exception;
    public void createAuth(MemberAuth memberAuth) throws Exception;
    // Read
    public List<Member> list() throws Exception;

    // Update
    public void update(Member member) throws Exception;
    // 권한 수정
    public void updateAuth(MemberAuth memberAuth) throws Exception;
    // delete
    public void delete(int userNo) throws Exception;
    // 권한 삭제
    public void deleteAuth(int userNo);

    // 상세 페이지
    public Member read(int userNo) throws Exception;

    // 회원 테이블 데이터 건수 조회
    public int countAll() throws Exception;

    // 사용자 아이디로 회원 정보 조회
    public Member readByUserId(String userId);
}
