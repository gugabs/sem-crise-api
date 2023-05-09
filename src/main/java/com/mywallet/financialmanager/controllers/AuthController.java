package com.mywallet.financialmanager.controllers;

import com.mywallet.financialmanager.dtos.UserDTO;
import com.mywallet.financialmanager.models.User;
import com.mywallet.financialmanager.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class AuthController {
  @Autowired
  private AuthService userService;

  @PostMapping("/auth/sign-up")
  @ResponseStatus(HttpStatus.CREATED)
  public HashMap<String, Object> SignUp(@RequestBody UserDTO user) {
    HashMap<String, Object> response = new HashMap<>();

    User createdUser = this.userService.signUp(user);

    response.put("id", createdUser.getId());
    response.put("email", createdUser.getEmail());

    return response;
  }

  @PostMapping("/auth/sign-in")
  @ResponseStatus(HttpStatus.OK)
  public HashMap<String, String> SignIn(@RequestBody UserDTO user) {
    HashMap<String, String> response = new HashMap<>();

    response.put("token", this.userService.signIn(user));

    return response;
  }
}
