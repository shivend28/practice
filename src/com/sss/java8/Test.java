package com.sss.java8;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Exchange e = new Exchange();
        new Producer(e);
    }
}

class Exchange {
    List<String> reqs = new ArrayList<>();
    List<Consumer> consumers = new ArrayList<>();
    public void acceptRequestReq(String str) {
        reqs.add(str);
    }

    public void registerConsumer(Consumer consumer) {
        consumers.add(consumer);
    }
}

class Producer {
    Exchange e;
    public Producer(){}
    public Producer(Exchange e) {
        this.e = e;
    }

    public void produceMsg(String s) {
        e.acceptRequestReq(s);
    }
}

class Consumer {

}