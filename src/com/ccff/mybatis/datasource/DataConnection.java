package com.ccff.mybatis.datasource;

import com.ccff.mybatis.dao.IBasketballPlayerDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DataConnection {
    //mybatis配置文件
    private String resource = "SqlMapConfig.xml";
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    public SqlSession getSqlSession() throws IOException {
        if (sqlSessionFactory == null){
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //创建会话工厂，传入mybatis配置文件的信息
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    public IBasketballPlayerDao getBasketballPlayerMapper() {
        IBasketballPlayerDao basketballPlayerMapper = sqlSession.getMapper(IBasketballPlayerDao.class);
        return basketballPlayerMapper;
    }
}
