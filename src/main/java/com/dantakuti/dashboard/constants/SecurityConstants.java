package com.dantakuti.dashboard.constants;

/**
 * @author adarshbhattarai on 2019-06-18
 * @project dashboard
 */
public class SecurityConstants {

    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 86400000L; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/auth/sign-up";
    public static final String LOGIN_URL = "/auth/login";
}
