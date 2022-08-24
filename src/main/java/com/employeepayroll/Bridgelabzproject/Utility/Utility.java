package com.employeepayroll.Bridgelabzproject.Utility;


public class Utility {
    /*
    Method to get response
     */
    public static Response getResponse(String message, Object data) {
        return new Response(message, data);
    }

}
