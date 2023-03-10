package de.webapplication.rezeptobot.models.enums;

public enum EventHintergrundEnum {

    INTERNES_REZEPT("#00cc99"),
    ALTERNATIVES_REZEPT("#FFFFCC"),
    ESSENSBESTELLUNG("#FFCC99"),
    AUSWAERTS("#66CCFF");

    private String hintergrundfarbe;

    private EventHintergrundEnum(String hintergrundfarbe) {
        this.hintergrundfarbe = hintergrundfarbe;
    }
    
}
