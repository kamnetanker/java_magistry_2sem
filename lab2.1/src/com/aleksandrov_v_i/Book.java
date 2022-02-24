package com.aleksandrov_v_i;

public class Book {
    // ===== data =====
    private String _name;
    private String _author;
    private short _year;
    private String _genre;
    private static Owner _owner;
    // ===== end data =====

    // ===== getters/setters =====
    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_author() {
        return _author;
    }

    public void set_author(String _author) {
        this._author = _author;
    }

    public short get_year() {
        return _year;
    }

    public void set_year(short _year) {
        this._year = _year;
    }

    public String get_genre() {
        return _genre;
    }

    public void set_genre(String _genre) {
        this._genre = _genre;
    }

    public static Owner get_owner() {
        return Book._owner;
    }

    public static void set_owner(Owner _owner, String _password) {
        if(_password=="somepass") {
            Book._owner = _owner;
        }
    }
    // ===== end getters/setters =====

    // ===== constructors =====
    Book(String _name, String _author, short _year, String _genre){
        this._author = _author;
        this._name = _name;
        this._year = _year;
        this._genre = _genre;
    }
    Book(String _name, String _author,  String _genre){
        this( _name, _author, (short) 1971, _genre);
    }
    // ===== end constructors =====
}
