package com.backend.backend.service;

import com.backend.backend.model.User;

public interface AuthService {
    User loginUser(String email, String password);
}
