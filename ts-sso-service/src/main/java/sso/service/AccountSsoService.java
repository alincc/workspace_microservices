package sso.service;

import sso.domain.*;

public interface AccountSsoService {

    RegisterResult create(RegisterInfo ri);

    Account createAccount(Account account);

    LoginResult login(LoginInfo li);

    PutLoginResult loginPutToken(String loginToken);

    LogoutResult logoutDeleteToken(LogoutInfo li);

    VerifyResult verifyLoginToken(String verifyToken);

}
