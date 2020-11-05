package com.ylee.a06xmljson;

public class SBooks implements Comparable<SBooks> {
    String author;
    String title;
    Float price;

    public SBooks(String author, String title, Float price) {
        this.author = author;
        this.title = title;
        this.price = price;
    }

    @Override
    // 가격에 의한 내림차순 정렬
//    public int compareTo(SBooks o) {
//        if(this.price > o.price){
//            return -1;
//        }else if(this.price < o.price){
//            return 1;
//        }
//        return 0;
//    }

    // 저자에 의한 오름차순 정렬
    public int compareTo(SBooks o) {
        return this.author.compareTo(o.author);
    }

    // 타이틀에 의한 내림차순 정렬렬
}
