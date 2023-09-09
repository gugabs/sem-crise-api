package com.mywallet.financialmanager.controllers;

import com.mywallet.financialmanager.dtos.UserDTO;
import com.mywallet.financialmanager.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class AuthController {
  @Autowired
  private AuthService authService;

  @PostMapping("/auth/sign-up")
  @ResponseStatus(HttpStatus.CREATED)
  public void SignUp(@RequestBody UserDTO user) {
    this.authService.signUp(user);
  }

  @PostMapping("/auth/sign-in")
  @ResponseStatus(HttpStatus.OK)
  public HashMap<String, String> SignIn(@RequestBody UserDTO user) {
    HashMap<String, String> response = new HashMap<>();

    response.put("token", this.authService.signIn(user));

    return response;
  }
}
