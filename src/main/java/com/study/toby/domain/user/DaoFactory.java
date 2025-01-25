package com.study.toby.domain.user;

public class DaoFactory {
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
    public ConnectionMaker connectionMaker() {
        return new SimpleConnectionMaker();
    }
}
