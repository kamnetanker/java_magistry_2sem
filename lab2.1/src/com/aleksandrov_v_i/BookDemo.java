package com.aleksandrov_v_i;

public class BookDemo {
    public void do_something(){
        Owner o = new Owner();
        Book.set_owner(o, "somepass");

        Book b1=new Book("A", "A_a", "horror");
        Book b2 = new Book("B", "B_a", "comedy");
        Book b3 = new Book("C", "C_a", "fighting");

        Book[] b_arr = new Book[]{b1,b2,b3};
        Book[] b_arr2 = new Book[3];
        b_arr2[0] = b1;
        b_arr2[1] = b2;
        b_arr2[2] = b3;
        for(Book b : b_arr){
            System.out.println(b.get_author()+" "+b.get_name()+" "+b.get_genre());
        }
    }
}
