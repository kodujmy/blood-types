package pl.kodujmy;

import java.util.List;
import java.util.stream.Collectors;

public class BloodTypes {
    boolean survive(String bloodType, List<String> donatedBlood) {
        List<String> recipents = donatedBlood
                .stream()
                .map(b -> BloodType.fromSymbol(b).getRecipients())
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return recipents.contains(bloodType);
    }

}
