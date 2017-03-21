package com.wu.service;

import com.wu.common.exception.TokenException;


public interface UserTokenService {
    String queryTokenByUserId(int userId);

    Integer queryUserIdByToken(String token) throws TokenException;

    void saveUserToken(int userId, String token);

    void exit(String token);
}
