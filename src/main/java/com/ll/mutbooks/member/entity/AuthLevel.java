package com.ll.mutbooks.member.entity;

import lombok.Getter;

@Getter
public enum AuthLevel {

    USER("USER"), AUTHOR("AUTHOR"), ADMIN("ADMIN");

    AuthLevel(String role) {
        this.role = role;
    }

    private final String role;
}
