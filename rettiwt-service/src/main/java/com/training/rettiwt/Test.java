package com.training.rettiwt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello");
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        System.out.println(list);
        System.out.println(stream);
    }
}
