package com.school.entidade.exceptions;

@FunctionalInterface
public interface ThrowingInterface {
    void execute() throws RuntimeException;
}
