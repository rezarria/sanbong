package io.rezarria.sanbong.security;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;

public class Details {
    private final Map<String, String> map;

    public Details() {
        map = new LinkedHashMap<>();
    }

    public static Details from(Claims claims) {
        Details details = new Details();
        claims.entrySet().stream().filter(e -> e.getKey().startsWith("details__")).forEach(e -> details.set(e.getKey().substring(9), (String) e.getValue()));
        return details;
    }

    public void set(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }

    public Stream<Map.Entry<String, String>> stream() {
        return map.entrySet().stream();
    }

    public void addToClaims(JwtBuilder.BuilderClaims claims) {
        map.forEach((k, v) -> claims.add(String.format("details__%s", k), v));
    }

    public String getUserId() {
        return map.get("userId");
    }

    public void setUserId(String userId) {
        map.put("userId", userId);
    }

    public String getAccountId() {
        return map.get("accountId");
    }

    public void setAccountId(String accountId) {
        map.put("accountId", accountId);
    }

}
