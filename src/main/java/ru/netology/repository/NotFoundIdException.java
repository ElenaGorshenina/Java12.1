package ru.netology.repository;

public class NotFoundIdException extends RuntimeException {

    public NotFoundIdException(String s) {
        super(s);
    }
}
