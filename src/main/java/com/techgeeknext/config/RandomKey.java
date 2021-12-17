package com.techgeeknext.config;

import com.techgeeknext.bean.TokensBean;

public class RandomKey {
	  
	public String key = null;
	private static RandomKey single_instance=null;
    private RandomKey() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "!@#*$"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        StringBuilder sb = new StringBuilder(8);
  
        for (int i = 0; i < 8; i++) {
  
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        key=sb.toString();
    }
    
    public static RandomKey getInstance()
    {
     if (single_instance == null)
     single_instance = new RandomKey();
     return single_instance;
    }
}