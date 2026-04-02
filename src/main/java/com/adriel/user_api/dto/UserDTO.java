package com.adriel.user_api.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
    private String userName;
    private String cpf;
    private String adress;
    private String email;
    private String phone;
    private Date registrationDate;

}
