package com.epam.apartmentbooking.service.util;

import org.springframework.stereotype.Component;

@Component
public class HashScrambler {
	
	public int encrypt(char[] input){
        int hash = 3;

        for(int i=0;i<input.length;i++){  
            hash = 47 * hash + input[i];
        }

        return hash;
    }
	
}
