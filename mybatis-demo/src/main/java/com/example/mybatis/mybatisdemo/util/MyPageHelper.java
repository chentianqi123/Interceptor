package com.example.mybatis.mybatisdemo.util;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

@Intercepts(@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class}))
public class MyPageHelper implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler,
                SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                new DefaultReflectorFactory());

        String value = (String)metaObject.getValue("delegate.mappedStatement.id");
        //        自定义匹配规则 只要是ByPage结尾的就使用插件
        if(value.matches(".*ByPage$")){
            Connection connection = (Connection)invocation.getArgs()[0];
            String sql = statementHandler.getBoundSql().getSql();
            String countsql = "select * from ("+sql+") as a";
            PreparedStatement preparedStatement = connection.prepareStatement(countsql);
            //渲染参数
            ParameterHandler parameterHandler = statementHandler.getParameterHandler();
            parameterHandler.setParameters(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            //传入的map
            Map<String, Object> parameterObject = (Map<String, Object>) parameterHandler.getParameterObject();
            PageUtil pageUtil = (PageUtil) parameterObject.get("page");

            if(resultSet.next()){
                int anInt = resultSet.getInt(1);
                pageUtil.setCount(anInt);
            }

            String pagesql = sql + " limit " + pageUtil.getStartNum() + "," + pageUtil.getLimit() + "";
            metaObject.setValue("delegate.boundSql.sql",pagesql);
        }
        //放行
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
