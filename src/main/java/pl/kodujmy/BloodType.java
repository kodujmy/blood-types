package pl.kodujmy;

import java.util.Arrays;
import java.util.List;

public enum BloodType {
    A_PLUS("A+", List.of("AB+", "A+")),
    A_MINUS("A-", List.of("AB-", "AB+", "A-", "A+")),
    B_PLUS("B+", List.of("AB+", "B+")),
    B_MINUS("B-", List.of("AB-","AB+", "B-", "B+")),
    ZERO_MINUS("0-", List.of("A+","A-","B+", "B-", "AB+", "AB-", "0-", "0+")),
    ZERO_PLUS("0+", List.of("AB+", "0+", "B+", "A+")),
    AB_PLUS("AB+", List.of("AB+")),
    AB_MINUS("AB-", List.of("AB-", "AB+"));

    private String symbol;
    private List<String> recipients;

    BloodType(String symbol, List<String> recipients) {
        this.symbol = symbol;
        this.recipients = recipients;
    }

    public static BloodType fromSymbol(String symbol) {
        return Arrays.stream(values()).filter(b -> b.symbol.equals(symbol)).findFirst().get();
    }

    public List<String> getRecipients() {
        return recipients;
    }
}
