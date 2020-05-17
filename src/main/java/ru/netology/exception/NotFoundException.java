package ru.netology.exception;

public class NotFoundException {
    public void NPE() throws RuntimeException {
        throw new NullPointerException();
    }

}
