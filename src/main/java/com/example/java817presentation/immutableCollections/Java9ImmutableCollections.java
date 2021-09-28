package com.example.java817presentation.immutableCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Java9ImmutableCollections {
    public static void main(String[] args)
    {
        List<String> sportList = new ArrayList<String>();

        sportList.add("Hockey");
        sportList.add("Cricket");
        sportList.add("Tennis");

        List<String> unModifiableSportList = Collections.unmodifiableList(sportList);

        System.out.println(sportList);    //Output : [Hockey, Cricket, Tennis]

        System.out.println(unModifiableSportList);    //Output : [Hockey, Cricket, Tennis]

//        unModifiableSportList.add("Wrestling");     //It gives run-time error

        sportList.add("Kabaddi");      //It gives no error and will be reflected in unModifiableSportList

        System.out.println(sportList);    //Output : [Hockey, Cricket, Tennis, Kabaddi]

        System.out.println(unModifiableSportList);    //Output : [Hockey, Cricket, Tennis, Kabaddi]



        List<String> immutableSportList = List.of("Hockey", "Cricket", "Tennis");
        List<String> immutableEmptySportList = List.of();
//        immutableEmptySportList.add("Chess");

    }
}
