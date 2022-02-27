package com.kamnetanker;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.printf("Simple game performer with interface realisation\n");
        GameStarter gs = new GameStarter();
        gs.PerformApplication(3, new EDisciplines[]{EDisciplines.jump, EDisciplines.pushups, EDisciplines.run});
        System.out.printf("Bye!\n");
    }
}
