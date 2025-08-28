package com.restaurant.productmanagement.dto;



import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class RegisterDto {
    @JsonAlias("a")
    private String name;

    @JsonAlias("b")
    private String email;

    @JsonAlias("c")
    private String password;
}
