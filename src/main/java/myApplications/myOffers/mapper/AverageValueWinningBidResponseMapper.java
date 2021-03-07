package myApplications.myOffers.mapper;

import myApplications.myOffers.dao.Month;
import myApplications.myOffers.dao.Offer;
import myApplications.myOffers.response.AverageValueWinningBidResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class AverageValueWinningBidResponseMapper {

    public AverageValueWinningBidResponse maToResponse(List<Offer> offers) {
        //TODO: zamiast sprwdzenia nulla na początku prostym ifem, to opakowujemy element w Optionala korzystając z
        //TODO: methody .ofNullable()
        double average = Optional.ofNullable(offers)
                .orElse(Collections.emptyList())
                .stream()
                //TODO: ten filter ratuje Cie przed NPE
                .filter(Objects::nonNull)
                .filter(e -> Month.JAN.equals(e.getMonth()))
                .filter(Offer::isWinningBid)
                .mapToDouble(Offer::getValue1)
                .average()
                .orElse(Double.NaN);

        return new AverageValueWinningBidResponse(Month.JAN, average);
    }
}
