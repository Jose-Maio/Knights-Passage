package controller;

public interface Controller<T> {
    T start() throws Exception;
    void handleInput() throws Exception;
    T update() throws Exception;
}
