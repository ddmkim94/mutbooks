package com.ll.mutbooks.member.entity;

import com.ll.mutbooks.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@SuperBuilder
public class Member extends BaseEntity {

    private String username;
    private String password;
    private String nickname;
    private String email;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private AuthLevel authLevel;
}
