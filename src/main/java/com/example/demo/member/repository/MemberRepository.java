package com.example.demo.member.repository;

import com.example.demo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByUsername(String username);

    Member findMemberByUsername(String username);

    @Query("SELECT m FROM Member m " +
            "JOIN m.followList f " +
            "JOIN f.shop s " +
            "WHERE s.member.id = :memberId")
    List<Member> findFollowersByMember_Id(Long memberId);

    @Query("SELECT m FROM Member m " +
            "JOIN m.shop s " +
            "JOIN s.follows f " +
            "WHERE f.member.id = :memberId")
    List<Member> findFollowingsByMember_Id(Long memberId);

    Optional<Member> findByNickname(String nickname);
}
