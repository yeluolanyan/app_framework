package com.wu.service.impl;

import com.wu.common.exception.TokenException;
import com.wu.common.redis.RedisClient;
import com.wu.common.utils.CommonEnum;
import com.wu.common.utils.Constants;
import com.wu.mapper.UserTokenMapper;
import com.wu.mapper.ext.UserTokenMapperExt;
import com.wu.model.UserToken;
import com.wu.model.UserTokenExample;
import com.wu.service.UserTokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MJN on 2017/3/21.
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {
    @Autowired
    private UserTokenMapperExt userTokenMapperExt;
    @Autowired
    private UserTokenMapper userTokenMapper;
    @Autowired
    private RedisClient redisClient;

    /**
     * 通过UserId查询有效期内的token
     * @param userId
     * @return
     */
    @Override
    public String queryTokenByUserId(int userId){
        String token = userTokenMapperExt.queryTokenByUserId(userId,(int)(System.currentTimeMillis()/1000 - Constants.TOKEN_TIME));
        return token;
    };

    /**
     * 根据token查询userId
     *
     * @param token
     * @return
     */
    @Override
    public Integer queryUserIdByToken(String token) throws TokenException {
        //TODO 从redis中查询userId
        String userId = redisClient.getString(CommonEnum.REDIS_USERID.getCode()+token);
        if(!StringUtils.isEmpty(userId)){
            return Integer.parseInt(userId);
        }else {
            int create_time = (int)(System.currentTimeMillis()/1000 - Constants.TOKEN_TIME);
            Integer uId = userTokenMapperExt.queryUserIdByToken(token,create_time);
            if(uId == null){
                throw new TokenException();
            }
            return uId;
        }
    }
    /**
     * 添加token
     * @param userId
     */
    @Override
    public void saveUserToken(int userId, String token){
        UserToken userToken = new UserToken();
        userToken.setToken(token);
        userToken.setCreateTime((int)(System.currentTimeMillis()/1000));
        userToken.setUserId(userId);
        userToken.setIsDel(CommonEnum.IS_DELETE_N.getCode());
        userTokenMapper.insert(userToken);
    }

    /**
     * 用户退出
     * @param token
     */
    @Override
    public void exit(String token){
        redisClient.delete(CommonEnum.REDIS_USERID.getCode()+token);
        UserTokenExample example = new UserTokenExample();
        example.or().andTokenEqualTo(token).andIsDelEqualTo(CommonEnum.IS_DELETE_N.getCode());
        UserToken userToken = new UserToken();
        userToken.setIsDel(CommonEnum.IS_DELETE_Y.getCode());
        userTokenMapper.updateByExampleSelective(userToken,example);
    }
}
