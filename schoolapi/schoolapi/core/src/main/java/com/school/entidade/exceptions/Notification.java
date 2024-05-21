package com.school.entidade.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Notification {

    private List<String> notifications = new ArrayList(){};

    public void add(ThrowingInterface throwError){
        try{
            throwError.execute();
        }catch (Exception e){
            notifications.add(e.getMessage());
        }
    }

    public void dispatch(){
        if(!notifications.isEmpty()){
            throw new NoStackTraceException(notifications.toString());
        }
    }

}
