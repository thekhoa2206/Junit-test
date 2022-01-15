package com.sapo.dto.sercurity;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class LoginForm {
    @Size(min = 6, max= 30, message = "Độ dài Username phải nằm trong khoảng 6 đến 30 ký tự")
    private String username;
    @Size(min = 6, max= 10, message = "Độ dài Password phải nằm trong khoảng 6 đến 10 ký tự")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
