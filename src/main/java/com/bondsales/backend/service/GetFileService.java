package com.bondsales.backend.service;

import org.springframework.stereotype.Service;

@Service
public class GetFileService {
    public boolean receiveFile(){
        try{
            return true;
        } catch (Exception e){
//            e.printStackTrace();
            return false;
        }
    }
}
