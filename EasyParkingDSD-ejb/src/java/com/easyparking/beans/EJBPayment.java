/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparking.beans;

import com.easyparking.lib.CreditCardValidation;
import java.util.Random;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author gustavoalegre
 */
@Stateless
@LocalBean
public class EJBPayment {

    public int processCreditCard(long number){
        int authNumber = 0;
        if (CreditCardValidation.isValid(number)){
            // Se genera un número aleatorio de validación
            Random rnd = new Random();
            authNumber =rnd.nextInt(414998) + 485001;
        }
        return authNumber;
    }
    
}
