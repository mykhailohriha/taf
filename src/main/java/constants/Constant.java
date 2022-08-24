package constants;

public class Constant {
    private Constant() {
    }

    public static class TimeoutVariable {
        private TimeoutVariable() {
        }

        public static final int IMPLICIT_WAIT = 4;
        public static final int EXPLICIT_WAIT = 10;
    }

    public static class Urls {
        private Urls() {
        }

        public static final String MAIN_PAGE = "http://localhost:8080/ui/#login";
        public static final String DASHBOARD_PAGE = "http://localhost:8080/ui/#default_personal/dashboard";
        public static final String GENERAL_SETTINGS = "http://localhost:8080/ui/#default_personal/settings/general";
    }
}
