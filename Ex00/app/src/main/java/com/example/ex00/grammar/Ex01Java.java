package com.example.ex00.grammar;

public class Ex01Java {
    public void printJava() {
        System.out.println("Hello world");
        char c1 = 'a';
        System.out.println(c1+1);
    }

    private class Person {
        String name;
    }

}
class Member {
    private String name;
    public Member(String name) {this.name = name;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}

class Tv2 {
    private int channel, volume;
    public Tv2(int channel, int volume) {
        if(channel > 0) this.channel = channel;
        if(volume > 0) this.volume = volume;
    }
}