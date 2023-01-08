package com.project.javalibrary.domain.member;

public class Member {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    public Member(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}
