package com.study.toby.domain.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
public class DaoFactory {

    @Bean // 오브젝트 생성을 담당하는 IoC용 메소드라는 표시
    public UserDao userDao() {
        //Factory 메소드는 UserDao 타입의 오브젝트를 어떻게 만들고, 어떻게 준비시킬지를 결정한다.
        return new UserDao(connectionMaker());
    }

    // 다음과 같은 Dao 를 추가할 수도 있음
//    public AccountDao accountDao() {
//        return new AccountDao(connectionMaker());
//    }
//
//    public MessageDao messageDao() {
//        return new MessageDao(connectionMaker());
//    }

    // 이런 분리를 통해 다른 Dao 추가 이후 ConnectionMaker 가 바뀔 때, connectionMaker()함수만 바꾸면 됨
    @Bean
    public ConnectionMaker connectionMaker() {
        return new SimpleConnectionMaker();
    }
}
