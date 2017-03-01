/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparking.ws;

import com.easyparking.beans.EJBMessaging;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author gustavoalegre
 */
@WebService(serviceName = "WSMessaging")
@Stateless()
public class WSMessaging {

    @EJB
    private EJBMessaging ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "sendMessage")
    public boolean sendMessage(@WebParam(name = "authCode") String authCode, @WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "subject") String subject, @WebParam(name = "message") String message) {
        return ejbRef.sendMessage(authCode, name, email, subject, message);
    }
    
}
