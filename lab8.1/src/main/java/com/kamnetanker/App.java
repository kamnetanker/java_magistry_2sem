package com.kamnetanker;


import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.Comparator;

class Book{
    private String title;
    private Integer pubYear;
    private ArrayList<String> authors;

    public Book(String title, Integer pubYear, ArrayList<String> authors) {
        this.title = title;
        this.pubYear = pubYear;
        this.authors = authors;
    }
    public String toString(){
        return "{ Book:{"+
                "title: "+this.title+" "+
                "pubYear: "+ this.pubYear.toString()+" "+
                "authors: "+ this.authors.toString()+"} }";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPubYear() {
        return pubYear;
    }

    public void setPubYear(Integer pubYear) {
        this.pubYear = pubYear;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

}
public class App 
{
    public static ArrayList<Book> readBooksFromFile(String filePath){
        String fileContent = "";
        try(FileReader fr = new FileReader(filePath)) {
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while((line = br.readLine())!=null){
                fileContent+=line+'\n';
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileContent);

        ArrayList<Book> book_array = new ArrayList<>();
        for(int i=0; i<fileContent.length(); i++){
            String title = fileContent.substring(i, fileContent.indexOf(',', i));
            i+=title.length()+2;

            Integer pubYear = Integer.parseInt(fileContent.substring(i, fileContent.indexOf(',', i)));
            i=fileContent.indexOf(',', i)+1;

            String[] authors = (fileContent.substring(i, fileContent.indexOf('\n', i))).split(",");
            ArrayList<String> authors_names = new ArrayList<>();
            for(String s : authors){
                authors_names.add(s);
            }
            book_array.add(new Book(title, pubYear, authors_names));
            i = fileContent.indexOf('\n', i);
        }
        return book_array;
    }
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        ArrayList<Book> al_book =  readBooksFromFile("./8-1.txt");

        Collections.sort(al_book, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPubYear() - o2.getPubYear();
            }
        });
        System.out.println(al_book.get(0).toString());

        Iterator<Book> ib = al_book.iterator();
        while(ib.hasNext()){
            Book b = ib.next();
            if((b.getAuthors()).size()==1){
                System.out.println(b.toString());
            }
        }

        SortedMap<String, Integer> m_si = new TreeMap<>();

        ib = al_book.iterator();
        while(ib.hasNext()){
            Book b = ib.next();
            for(String author : b.getAuthors()){
                if(m_si.containsKey(author)){
                    m_si.put(author, m_si.get(author)+1);
                }else{
                    m_si.put(author, 1);
                }
            }
        }
        Map.Entry<String, Integer> map_Entry_si = Collections.max(m_si.entrySet(), new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        System.out.println(map_Entry_si.toString());

        
        Set<String> authors_unique = new HashSet<>();
        ib = al_book.iterator();
        while(ib.hasNext()){
            Book b = ib.next();
            for(String author : b.getAuthors()){
                authors_unique.add(author);
            }
        }
        System.out.println(authors_unique);

    }
}
