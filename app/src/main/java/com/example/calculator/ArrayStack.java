package com.example.calculator;

class ArrayStack <E>{
    static final int CAPACITY = 20000;
    int tp = -1;
    E[] data;

    public ArrayStack(){
        this.data = (E[]) new Object[CAPACITY];
    }

    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    public void push(E e){
        tp += 1;
        data[tp] = e;
    }

    public E top(){
        if (tp == -1){
            return null;
        }
        return data[tp];
    }

    public E pop(){
        if (tp == -1){
            return null;
        }
        E answer = data[tp];
        tp -= 1;
        return answer;
    }


}
