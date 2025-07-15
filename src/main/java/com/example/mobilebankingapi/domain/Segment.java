package com.example.mobilebankingapi.domain;

public enum Segment {
    GOLD,
    SILVER,
    REGULAR;

    public static Segment fromString(String segment) {
        try {
            return Segment.valueOf(segment.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid segment: " + segment);
        }
    }
}
