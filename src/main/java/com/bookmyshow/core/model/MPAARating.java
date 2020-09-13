package com.bookmyshow.core.model;

public enum MPAARating {
    GeneralAudiences("G"),
    ParentalGuidanceSuggested("PG"),
    ParentsStronglyCautioned("PG-13"),
    Restricted("R"),
    AdultsOnly("NC-17");

    private String code;

    MPAARating(String code) {
        this.code = code;
    }
}
