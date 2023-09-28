package me.tony.practice.java21.job;

public sealed abstract class Designer implements Job {

    @Override
    public String named() {
        return "designer";
    }

    @Override
    public int salary() {
        return (int) (8000 * factor());
    }

    protected abstract double factor();

    public static final class Junior extends Designer {
        @Override
        public String named() {
            return STR. "junior \{ super.named() }" ;
        }

        @Override
        protected double factor() {
            return 1.0;
        }
    }

    public static final class Senior extends Designer {

        @Override
        public String named() {
            return STR. "senior \{ super.named() }" ;
        }

        @Override
        protected double factor() {
            return 1.6;
        }
    }
}
