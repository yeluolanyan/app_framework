package com.wu.mapper.ext;

import org.apache.ibatis.annotations.Param;

public interface UserTokenMapperExt {
    String queryTokenByUserId(@Param("user_id") int user_id, @Param("create_time") int create_time);
    Integer queryUserIdByToken(@Param("token") String token, @Param("create_time") int create_time);
}