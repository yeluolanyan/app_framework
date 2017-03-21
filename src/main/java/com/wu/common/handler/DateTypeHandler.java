package com.wu.common.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by lwh on 2016/6/12.
 */
@MappedTypes({Date.class})
@MappedJdbcTypes({JdbcType.INTEGER})
public class DateTypeHandler implements TypeHandler<Date> {
    public void setParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        int value = 0;
        if(date!=null){
            value = (int)(date.getTime()/1000);
        }
        preparedStatement.setInt(i, value);
    }

    public Date getResult(ResultSet resultSet, String s) throws SQLException {
        return new Date(resultSet.getInt(s)*1000l);
    }

    public Date getResult(ResultSet resultSet, int i) throws SQLException {
        return new Date(resultSet.getInt(i)*1000l);
    }

    public Date getResult(CallableStatement callableStatement, int i) throws SQLException {
        return new Date(callableStatement.getInt(i)*1000l);
    }
}
