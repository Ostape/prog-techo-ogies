package com.robosh;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = LinkedList.of(1,2,3,4,5,6);
        list.add(2, 33);
        outPut(list);
    }

    private static <T> void outPut(List<T> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
