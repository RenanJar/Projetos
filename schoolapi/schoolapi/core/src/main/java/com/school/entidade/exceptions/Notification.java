package com.school.entidade.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
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
