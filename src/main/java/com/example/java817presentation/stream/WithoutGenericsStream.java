package com.example.java817presentation.stream;

import java.util.List;

public class WithoutGenericsStream {
    class BadUsage {
        public int countDoubleInf(List numbers) {
            int count = 0;
            for (Object e : numbers) {
                if (e instanceof Double) {
                    Double d = (Double) e;
                    if (d.isInfinite()) {
                        count++;
                    }
                }
            }
            return count;
        }






        public int countDoubleInfs(List numbers) {
            int count = 0;
            for (Object e : numbers) {
                if (e instanceof Double d) {
                    if (d.isNaN()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }




    class GoodUsage {
        public int countDoubleInf(List numbers) {
            return  (int) numbers.stream()
                    .filter(Double.class::isInstance)
                    .mapToDouble(Double.class::cast)
                    .filter(Double::isInfinite)
                    .count();
        }
    }

}
