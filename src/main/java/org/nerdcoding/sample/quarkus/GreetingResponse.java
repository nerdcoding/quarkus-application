package org.nerdcoding.sample.quarkus;

public class GreetingResponse {

    private final String value;

    public GreetingResponse(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
