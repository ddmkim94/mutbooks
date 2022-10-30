package com.ll.mutbooks.member.entity;

import lombok.Getter;

@Getter
public enum AuthLevel {

    USER(3L), AUTHOR(5L), ADMIN(7L);

    AuthLevel(Long level) {
        this.level = level;
    }

    private final Long level;
}
