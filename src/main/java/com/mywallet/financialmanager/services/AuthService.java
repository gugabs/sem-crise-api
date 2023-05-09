package com.mywallet.financialmanager.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mywallet.financialmanager.dtos.UserDTO;
import com.mywallet.financialmanager.exceptions.DuplicatedEmailException;
import com.mywallet.financialmanager.exceptions.InvalidCredentialsException;
import com.mywallet.financialmanager.models.User;
import com.mywallet.financialmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {
  @Autowired
  private UserRepository userRepository;

  private Boolean comparePasswords(String typedPassword, String encryptedPassword) {
    return BCrypt.checkpw(typedPassword, encryptedPassword);
  }

  private String encodePassword(String password) {
    BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

    return bCrypt.encode(password);
  }

  private String generateToken(Integer userId) {
    HashMap<String, Integer> payload = new HashMap<>();

    payload.put("userId", userId);

    return JWT.create()
      .withPayload(payload)
      .sign(Algorithm.HMAC256("my-secret"));
  }

  private Boolean isDuplicatedUser(String email) {
    User duplicatedUser = this.userRepository.findByEmail(email);

    return duplicatedUser != null;
  }

  public User signUp(UserDTO user) {
    Boolean isDuplicatedUser = isDuplicatedUser(user.email());

    if (isDuplicatedUser) {
      throw new DuplicatedEmailException("E-mail already in use");
    }

    User newUser = new User();
    newUser.setEmail(user.email());
    newUser.setPassword(encodePassword(user.password()));

    return this.userRepository.save(newUser);
  }

  public String signIn(UserDTO user) {
    User foundUser = this.userRepository.findByEmail(user.email());

    if (foundUser == null) {
      throw new InvalidCredentialsException("Invalid credentials");
    }

    Boolean isTheSamePassword = comparePasswords(user.password(), foundUser.getPassword());

    if (!isTheSamePassword) {
      throw new InvalidCredentialsException("Invalid credentials");
    }

    return this.generateToken(foundUser.getId());
  }
}
