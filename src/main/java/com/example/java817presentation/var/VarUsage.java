package com.example.java817presentation.var;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class VarUsage {
   void test() throws IOException {
       URL url = new URL("http://google.com");
       URLConnection connection = url.openConnection();
    Reader reader = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
   }
   void test1() throws IOException {
       var url = new URL("http://google.com");
       var connection = url.openConnection();
       var reader = new BufferedReader(
               new InputStreamReader(connection.getInputStream()));
   }
//   void test2(){
//       var foo;
//       foo = "Foo";
//       var ints = {0, 1, 2};
//       var appendSpace = a -> a + " ";
//       var compareString = String::compareTo;
//   }
   void test3(){
       // var in for loops
       var letters = List.of("a", "b", "c");
       for (var nr : letters)
           System.out.print(nr + " ");
       for (var i = 0; i < letters.size(); i++)
           System.out.print(letters.get(i) + " ");
   }
//    private var getFoo() {
//        return "foo";
//    }
}
