package com.practice.entity;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginData {
    @NotBlank(message = "User Name can not be empty !!")
    @Size(min = 3, max = 20, message = "User Name must be between 3-20 characters !!")
    private String userName;

    // can also use @Pattern instead of @Email. But the automatic error modifier
    // won't be there is used @Pattern
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email !!!")
    private String email;

    // if false, will generate error
    @AssertTrue(message = "Must agree terms and conditions")
    private boolean agreed;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

}
