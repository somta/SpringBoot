package net.somta.springboot.webservice.service;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface UserService {
    String getUser(@WebParam(name = "userId") String userId);
}