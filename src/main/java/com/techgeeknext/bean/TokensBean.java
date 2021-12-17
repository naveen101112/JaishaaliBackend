package com.techgeeknext.bean;

import java.util.Vector;

public class TokensBean { 
    private static TokensBean single_instance = null;
    public Vector<String> beans;
    private TokensBean()
    {
    	beans=new Vector<String>();
    }
    
    public static TokensBean getInstance()
    {
     if (single_instance == null)
     single_instance = new TokensBean();
     return single_instance;
    }
    
    public void addToken(String token) {
    	beans.add(token);
    }
  }