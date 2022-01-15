package com.sapo.dto.users;

import com.sapo.dto.role.RoleDTOListResponse;
import com.sapo.entities.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class UserDTORequest{

    @NotNull(message = "Tên đăng nhập không được để trống")
    @NotBlank(message = "Tên đăng nhập không được để trống")
    @Size(min = 6, max= 30, message = "Độ dài Username phải nằm trong khoảng 6 đến 30 ký tự")
    private String username;

    @NotNull(message = "Mật khẩu không được để trống")
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, max= 10, message = "Độ dài Password phải nằm trong khoảng 6 đến 10 ký tự")
    private String password;

    private String email;

    @NotNull(message = "Số điện thoại không được để trống")
    @NotBlank(message = "Số điện thoại không được để trống")
    @Size(min = 10, max = 10, message = "Số điện thoại phải có 10 chữ số")
    private String phone;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
