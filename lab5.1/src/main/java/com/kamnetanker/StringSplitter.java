package com.kamnetanker;

public class StringSplitter {
    public static String[] SplitString(String line_in){
        char[] line = line_in.toCharArray();
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
        return splitted_line;
    }
}
