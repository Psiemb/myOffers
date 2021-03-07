package myApplications.myOffers.mapper;

import com.sun.xml.bind.v2.TODO;
import myApplications.myOffers.dao.Offer;
import myApplications.myOffers.response.NameRandomResponse;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class NameRandomResponseMapper {

    public NameRandomResponse mapToResponse(List<Offer> offers) {
        Random rand = new Random();

        List<String> collect = Optional.ofNullable(offers)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(Offer::isWinningBid)
                .map(Offer::getName)
                .collect(Collectors.toList());
        if (collect.size() == 0){
            return null;
        }
        int nextInt = rand.nextInt(collect.size());
        String randomElement = collect.get(nextInt); //Losujemy Name z listy  collect

        return new NameRandomResponse(randomElement);
    }
}
