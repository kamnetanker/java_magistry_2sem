package com.kamnetanker;
import org.apache.commons.lang.NullArgumentException;

import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.Dictionary;
import java.util.regex.Pattern;


public class MainClass {
    static void validateInput(String _from, String _to, String regExp) throws Exception {
        if (_from == null) {
            throw new NullArgumentException("[ERR] _from cannot be null");
        }
        if (!Files.exists(Paths.get(_from))) {
            throw new IOException("[ERR] Path _from(" + _from + ") does not exist");
        }
        if (!Files.isDirectory(Paths.get(_from))) {
            throw new IOException("[ERR] Path _from(" + _from + ") does not directory");
        }
        if (_to == null) {
            throw new NullArgumentException("[ERR] _from cannot be null");
        }
        if (!Files.exists(Paths.get(_to))) {
            System.err.println("[WARN] Path _to(" + _to + ") does not exist. Creating...");
            Files.createDirectory(Paths.get(_to));
        }
        if (!Files.isDirectory(Paths.get(_to))) {
            throw new IOException("[ERR] Path _to(" + _to + ") does not directory");
        }
        if (regExp == null) {
            throw new NullArgumentException("[ERR] regExp cannot be null");
        }
    }

    static void replaceFiles(String _from, String _to, String regExp, boolean skip_validation) throws Exception {
        if (!skip_validation) {
            try {
                validateInput(_from, _to, regExp);
            } catch (Exception ex) {
                throw ex;
            }
        }

        _from = Paths.get(_from).toAbsolutePath().toString();
        _to = Paths.get(_to).toAbsolutePath().toString();

        String _list_of_paths[] = (new File(_from)).list();
        for (String _lop : _list_of_paths) {
            String _lop_abs = _from + "\\" + _lop;
            if (Files.isDirectory(Paths.get(_lop_abs))) {
                replaceFiles(_lop_abs, _to, regExp, true);
            } else if (Pattern.matches(regExp, _lop)) {
                try {
                    Files.move(Paths.get(_lop_abs), Paths.get(_to + "\\" + _lop));
                } catch (IOException iox) {
                    System.err.println(iox.getMessage());
                }
            } else {
                System.err.println("[WARN] regExp does not match " + regExp + " " + _lop);
            }
        }

    }

    static void replaceFiles(String _from, String _to, String regExp) throws Exception {
        try {
            validateInput(_from, _to, regExp);
        } catch (Exception ex) {
            throw ex;
        }
        replaceFiles(_from, _to, regExp, true);
    }


    public static void main(String args[]) {

        String _from_array[] = new String[]{"Directory_for_lab6"};
        String _to_array[] = new String[]{
                "Lectures",
                "Laboratories",
                "Questions"
        };
        String _regExp_array[] = new String[]{
                "[\\S]*Lectu[\\S]*",
                "Lab[\\S]*",
                "Quest[\\S]*"
        };

        for (String _f : _from_array) {
            for (int i = 0; i < _to_array.length && i < _regExp_array.length; i++) {
                try {
                    replaceFiles(_f, _to_array[i], _regExp_array[i]);
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }

            }
        }

        //========================================================
        String _path_to_exts_directory = "Exts";
        String _exts_files[] = (new File(_path_to_exts_directory)).list();
        String _extensions[] = new String[_exts_files.length];
        int _extensions_pointer = 0;
        for(String _ef : _exts_files){

            if(!Files.isDirectory(Paths.get(_path_to_exts_directory+"\\"+_ef))){

                String _ext = _ef.substring(_ef.lastIndexOf('.'));
                int i = 0;
                for( ;i<_extensions.length&&i<_extensions_pointer&&!_extensions[i].equals(_ext); i++);
                if(i==_extensions_pointer){
                    _extensions[_extensions_pointer]=_ext;
                    _extensions_pointer++;
                }

            }

        }

        try(FileWriter _fw = new FileWriter(_path_to_exts_directory+"\\info.txt",false)){

            for(int i=0; i<_extensions_pointer; i++){
                _fw.write(_extensions[i]+"\n");
            }

        }catch (IOException iox){

            System.err.println(iox.getMessage());

        }


    }
}
