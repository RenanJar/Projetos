package com.school.aluno;

import com.school.entidade.exceptions.DomainExceptions;
import com.school.entidade.exceptions.Notification;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class NotificationTest {

    @Test
    public void whenTrowingOneOrMoreExceptions_itMustBeTurnedIntoANotification(){

        Notification notification = new Notification();

        notification.add(()->{
            throw DomainExceptions.throwException("One Error","Aluno");
        });

        notification.add(()->{
            throw DomainExceptions.throwException("Other Error","Aluno");
        });

        try{
            notification.dispatch();
        }catch (Exception e){
            Assert.assertEquals("[DOMAIN_Aluno: One Error, DOMAIN_Aluno: Other Error]", e.getMessage());
        }
    }

    @Test
    public void whenCallDispatch_ifThereNoExcepetions_notThrowsExceptions(){
        String expected = "NotBeNull";

        Notification notification = new Notification();
        notification.add(()-> Objects.requireNonNull(expected));
        notification.dispatch();

        Assert.assertTrue(expected.equals("NotBeNull"));
    }
}
