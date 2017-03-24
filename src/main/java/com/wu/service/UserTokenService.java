package com.wu.service;



public interface UserTokenService {
    String queryTokenByUserId(int userId);

    Integer queryUserIdByToken(String token);

    void saveUserToken(int userId, String token);

    void exit(String token);
}
