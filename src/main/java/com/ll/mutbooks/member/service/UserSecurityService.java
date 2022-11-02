package com.ll.mutbooks.member.service;

import com.ll.mutbooks.member.entity.AuthLevel;
import com.ll.mutbooks.member.entity.Member;
import com.ll.mutbooks.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> findMember = memberRepository.findByusername(username);
        if (findMember.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }

        Member member = findMember.get();

        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(AuthLevel.ADMIN.getRole()));
        } else {
            if(member.getNickname() != null) {
                authorities.add(new SimpleGrantedAuthority(AuthLevel.AUTHOR.getRole()));
            }
            authorities.add(new SimpleGrantedAuthority(AuthLevel.USER.getRole()));
        }

        return new User(member.getUsername(), member.getPassword(), authorities);
    }
}
