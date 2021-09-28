package com.example.java817presentation.optional;

import com.example.java817presentation.domain.AutoBiography;
import com.example.java817presentation.domain.School;
import com.example.java817presentation.domain.User;

import static java.util.Optional.ofNullable;

public class FindMaybeNull {
    class BadUsage {
        public String getUserAutoBiographySchoolName(User user) {
            String schoolName = "Unknown";
            if (ofNullable(user).isPresent()) {
                if (user.getAutoBiography().isPresent()) {
                    if (user.getAutoBiography().get().getSchool().isPresent()) {
                        schoolName = user.getAutoBiography().get().getSchool().get().getName();
                    }
                }
            }
            return schoolName;
        }
    }
    class StillBadUsage {
        public String getUserAutoBiographySchoolName(User user) {
            final StringBuilder builder = new StringBuilder();
            ofNullable(user).ifPresent(
                    p -> p.getAutoBiography().ifPresent(
                            c -> c.getSchool().ifPresent(
                                    i -> builder.append(i.getName())
                            )
                    )
            );
            return builder.toString();
        }
    }




//    class UsingMapIdeaButStillBadUsage {
//        public String getUserAutoBiographySchoolName(User user) {
//            return ofNullable(user)
//                    .map(User::getAutoBiography)
//                    .map(autoBiography -> autoBiography.get().getSchool())
//                    .map(school -> school.getName())
//                    .orElse("Unknown");
//        }
//    }








    class UsingFlatMapGoodUsage {
        public String getCarInsuranceNameFromPersonUsingFlatMap(User user) {
            return ofNullable(user)
                    .flatMap(User::getAutoBiography)
                    .flatMap(AutoBiography::getSchool)
                    .map(School::getName)
                    .orElse("Unknown");
        }
    }
}
