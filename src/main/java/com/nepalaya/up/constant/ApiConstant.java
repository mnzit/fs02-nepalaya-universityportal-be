package com.nepalaya.up.constant;

public interface ApiConstant {

    String PING = "/";
    String LOGIN = "/login";
    String FAVICON = "/favicon.ico";
    String SUBMIT_ATTENDANCE = "/submitAttendance";
    String FORGOT_PASSWORD = "/forgotPassword";
    String PROFILE = "/profile";
    String USERS = "/users";
    String SEARCH = "/search";
    String USER_EMAIL = "userEmail";
    String USER_BY_EMAIL = "/" + "{" + USER_EMAIL + "}";
    String ID = "id";
    String WRAPPED_ID = "/{" + ID + "}";

    String BOOKS = "/books";
    String COURSES = "/courses";
    String COPY = "/copy";
    String NUMBER = "/{number}";
    String ACTION = "/action";
    String STATE = "state";
    String HOLIDAY = "/holidays";

    // List all the API Paths to bypass Authentication Here
    String[] UNSECURE = new String[]{
            PING,
            LOGIN,
            FAVICON
    };
}
