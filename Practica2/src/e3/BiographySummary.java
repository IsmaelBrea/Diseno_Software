package e3;

import java.util.StringJoiner;

public record BiographySummary(String type, String gender, Integer bornDate, String area) {
    public String getSummary() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("Type: " + type());
        joiner.add("Gender: " + gender());
        joiner.add("Born Date: " + bornDate());
        joiner.add("Area: " + area());
        return joiner.toString();
    }
}