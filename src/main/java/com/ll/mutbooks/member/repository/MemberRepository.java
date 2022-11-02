package com.ll.mutbooks.member.repository;

import com.ll.mutbooks.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByusername(String username);

    Member findByUsernameOrEmail(String username, String email);
}

