package com.example.myproject;

import com.example.myproject.domain.users.Users;

import javax.servlet.http.HttpSession;

public class HttpUtils {
    public static final String SESSION_USER = "sessionUser";

    public static boolean isLogined(HttpSession session){
        Object sessionUser = session.getAttribute(SESSION_USER);
        if(sessionUser == null){
            return false;
        }
        return  true;
    }

    public static Users getUserFromSession(HttpSession session){
        if(!isLogined(session)){
            return null;
        }
        return (Users)session.getAttribute(SESSION_USER);
    }
}
