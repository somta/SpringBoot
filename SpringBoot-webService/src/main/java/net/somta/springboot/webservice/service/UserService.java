package net.somta.springboot.webservice.service;
import net.somta.springboot.webservice.model.User;
import net.somta.springboot.webservice.model.UserParam;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface UserService {

    User addUser(@WebParam(name = "userParam") UserParam userParam);

    String getUser(@WebParam(name = "userId") String userId);
}