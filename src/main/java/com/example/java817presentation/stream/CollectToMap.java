package com.example.java817presentation.stream;

import com.example.java817presentation.domain.User;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class CollectToMap {
        public Map<String, Integer> NotWorkingUsageGetMaxAgeByUserName(List<User> users) {
            return users.stream()
                    .collect(toMap(User::getName,
                            User::getAge));
        }















    public Map<String, Integer> VeryGoodUsageGetMaxAgeByUserName(List<User> users) {
        return users.stream()
                .collect(toMap(User::getName,
                        User::getAge,Integer::max));
    }



    public static void main(String[] args) {
        User user = new User(1l, "Vadim").
                setAge(21);
        User user1 = new User(2l,"Ignat").
                setAge(25);
        User user2 = new User(3l,"Ignat").
                setAge(33);
        List<User> users=List.of(user,user1,user2);
        System.out.println(new CollectToMap().VeryGoodUsageGetMaxAgeByUserName(users));
    }
}
