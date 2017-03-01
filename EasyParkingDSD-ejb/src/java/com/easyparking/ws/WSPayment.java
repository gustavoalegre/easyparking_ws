/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparking.ws;

import com.easyparking.beans.EJBPayment;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author gustavoalegre
 */
@WebService(serviceName = "WSPayment")
@Stateless()
public class WSPayment {

    @EJB
    private EJBPayment ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "processCreditCard")
    public int processCreditCard(@WebParam(name = "number") long number) {
        return ejbRef.processCreditCard(number);
    }
    
}
