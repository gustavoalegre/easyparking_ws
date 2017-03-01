/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparking.beans;

import java.util.Date;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author gustavoalegre
 */
@Stateless
@LocalBean
public class EJBMessaging {

    String authCode = "DN932FNWEFB83N9DA83724URH209EC";
    
    public boolean sendMessage(String authCode, String name, String email, String subject, String message){
        if (this.authCode.equals(authCode)) {
            String fromName = "EasyParking";
            String fromEmail = "easyparking@tecnocomperusac.com"; //requires valid gmail id
            String password = "easy123"; // correct password for gmail id
            String toEmail = email; // can be any email id 

            System.out.println("Inicio del envío del mensaje");
            Properties props = new Properties();
            props.put("mail.smtp.host", "tecnocomperusac.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);
            try {
                MimeMessage msg = new MimeMessage(session);
                //set message headers
                msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
                msg.addHeader("format", "flowed");
                msg.addHeader("Content-Transfer-Encoding", "8bit");
                msg.setFrom(new InternetAddress(fromEmail, fromName));
                msg.setSubject(subject, "UTF-8");
                msg.setText(message, "UTF-8");
                msg.setSentDate(new Date());
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
                System.out.println("Listo para enviar");
                Transport.send(msg);  
                System.out.println("Mensaje enviado!");
                return true;
	    }
	    catch (Exception e) {
                e.printStackTrace();
                return false;
	    }
        } else {
            return false;
        }
    }
    
}
