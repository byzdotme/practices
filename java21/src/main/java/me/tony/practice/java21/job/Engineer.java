package me.tony.practice.java21.job;

public sealed abstract class Engineer implements Job {
    @Override
    public String named() {
        return "engineer";
    }

    public static final class Junior extends Engineer {
        @Override
        public String named() {
            return STR. "junior \{ super.named() }" ;
        }

        @Override
        public int salary() {
            return 10_000;
        }
    }

    public static final class Senior extends Engineer {
        @Override
        public String named() {
            return STR. "senior \{ super.named() }" ;
        }

        @Override
        public int salary() {
            return 20_000;
        }
    }
}
