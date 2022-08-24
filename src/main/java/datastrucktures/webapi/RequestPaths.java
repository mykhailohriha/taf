package datastrucktures.webapi;

public enum RequestPaths {
    BASE_URL("http://localhost:8080"),
    BASE_API_URL("http://localhost:8080/api"),
    BASE_UI_URL("http://localhost:8080/ui"),
    REPORT_PORTAL_SERVICES("/composite/info");

    private final String requestPath;

    RequestPaths(String path) {
        this.requestPath = path;
    }

    public String getPath() {
        return requestPath;
    }
}
