package com.aleksandrov_v_i;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ===== part 1 =====
        BookDemo bd = new BookDemo();
        bd.do_something();
        // ===== part 1 end =====

        // ===== part 2 =====

        Scanner scn = new Scanner(System.in);
        char[] line = scn.nextLine().toCharArray();
        int lp=0; // line pointer in char array
        boolean wordf=false; // flag, that we in a word
        int wordc=0; // word counts
        StringBuilder word = new StringBuilder(); // word from string
        String[] splitted_line; // array of words
        int slp=0; // splitted line pointer

        // skip ' ' in front of line
        for(; line[lp] == ' '; lp++);
        // counting words
        for(; lp<line.length; lp++){
            if(line[lp]==' '){
                if(wordf==true){
                    wordc++;
                }
                wordf=false;
            }else{
                wordf=true;
            }
        }
        if(wordf==true){
            wordc++;
        }
        lp=0;
        splitted_line = new String[wordc];
        // skip ' ' in front of line
        for(; line[lp] == ' '; lp++);
        // splitting words
        for(; lp<line.length; lp++){
            if(line[lp]==' '){
                if(wordf==true){
                    splitted_line[slp]=word.toString();
                    word = new StringBuilder();
                    slp++;
                }
                wordf=false;
            }else{
                wordf=true;
                word.append(line[lp]);
            }
        }
        if(wordf==true){
            splitted_line[slp]=word.toString();
            word = new StringBuilder();
            slp++;
        }
        // output splitted array
        for(String str : splitted_line){
            System.out.println(str);
        }
        // ===== part 2 end =====
    }
}
