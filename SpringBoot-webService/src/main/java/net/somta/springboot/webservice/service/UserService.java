package net.somta.springboot.webservice.service;
import net.somta.springboot.webservice.model.User;
import net.somta.springboot.webservice.model.UserParam;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface UserService {

    @WebMethod(action = "http://service.webservice.springboot.somta.net/addUser")
    @WebResult(name="addUserResponse",targetNamespace = "http://service.webservice.springboot.somta.net/")
    User addUser(@WebParam(name = "userParam",targetNamespace = "http://service.webservice.springboot.somta.net/") UserParam userParam);

    /**
     * soap的调用必须要指定action
     * @param userId
     * @return
     */
    @WebMethod(action = "http://service.webservice.springboot.somta.net/getUser")
    @WebResult(name="getUserResponse",targetNamespace = "http://service.webservice.springboot.somta.net/")
    User getUser(@WebParam(name = "userId",targetNamespace = "http://service.webservice.springboot.somta.net/") String userId);
}