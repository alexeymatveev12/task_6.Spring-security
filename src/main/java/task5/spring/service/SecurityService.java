package task5.spring.service;



public interface SecurityService {


    String findLoggedInLogin();

    void autoLogin(String login, String password);
}
