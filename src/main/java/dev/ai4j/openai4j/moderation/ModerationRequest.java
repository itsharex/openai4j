package dev.ai4j.openai4j.moderation;

import dev.ai4j.openai4j.Experimental;
import dev.ai4j.openai4j.Model;

import java.util.Objects;

public class ModerationRequest {

    private final String input;
    private final String model;

    private ModerationRequest(Builder builder) {
        this.input = builder.input;
        this.model = builder.model;
    }

    public String input() {
        return input;
    }

    public String model() {
        return model;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof ModerationRequest
                && equalTo((ModerationRequest) another);
    }

    private boolean equalTo(ModerationRequest another) {
        return Objects.equals(model, another.model)
                && Objects.equals(input, another.input);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(model);
        h += (h << 5) + Objects.hashCode(input);
        return h;
    }

    @Override
    public String toString() {
        return "ModerationRequest{"
                + "input=" + input
                + ", model=" + model
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String input;
        private String model;

        private Builder() {
        }

        public Builder input(String input) {
            this.input = input;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        @Experimental
        public Builder model(Model model) {
            return model(model.stringValue());
        }

        public ModerationRequest build() {
            return new ModerationRequest(this);
        }
    }
}
