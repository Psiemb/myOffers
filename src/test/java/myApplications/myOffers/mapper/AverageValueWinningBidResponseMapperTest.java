package myApplications.myOffers.mapper;

import myApplications.myOffers.dao.Month;
import myApplications.myOffers.dao.Offer;
import myApplications.myOffers.dao.Stage;
import myApplications.myOffers.response.AverageValueWinningBidResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class AverageValueWinningBidResponseMapperTest {

    private AverageValueWinningBidResponseMapper averageValueWinningBidResponseMapper;

    @BeforeEach
    void setUp() {
        this.averageValueWinningBidResponseMapper = new AverageValueWinningBidResponseMapper();
    }

    @Test
    public void checkIfAverageValueIsProperInJan() {
        //given
        List<Offer> offers = Arrays.asList(new Offer(LocalDate.now(), "For Activ", Month.JAN, 5000000, Stage.IN_PREPARATION, true, "Krystyna"),
                new Offer(LocalDate.now(), "For Swietelsky", Month.JAN, 1500000, Stage.SENT, true,"Piotr"));

        //when
        AverageValueWinningBidResponse result = averageValueWinningBidResponseMapper.maToResponse(offers);

        //then
        Assertions.assertEquals(3250000.0, result.getAverage());
    }

    @Test
    public void test2() {
        //given
        List<Offer> offers = Arrays.asList(
                null,
                new Offer(LocalDate.now(), "For Swietelsky", Month.JAN, 1500000, Stage.SENT, true,"Wojciech"));

        //when
        AverageValueWinningBidResponse result = averageValueWinningBidResponseMapper.maToResponse(offers);

        //then
        Assertions.assertEquals(3250000.0, result.getAverage());
    }

    @Test
    public void test3() {
        //given
        List<Offer> offers = Arrays.asList(
                new Offer(null, null, null, -1500000, null, false, "Andrzej"));

        //when
        AverageValueWinningBidResponse result = averageValueWinningBidResponseMapper.maToResponse(offers);

        //then
        Assertions.assertEquals(Double.NaN, result.getAverage());
    }

    @Test
    public void test4() {
        //given
        List<Offer> offers = Arrays.asList(
                new Offer(LocalDate.now(), "For Swietelsky", Month.JAN, 1500000, Stage.SENT, true,"Kuba"),
                new Offer(LocalDate.now(), null, Month.JAN, 1500000, Stage.SENT, true,"Szymon"));

        //when
        AverageValueWinningBidResponse result = averageValueWinningBidResponseMapper.maToResponse(offers);

        //then
        Assertions.assertEquals(3250000.0, result.getAverage());
    }

    @Test
    public void test() {
        //when
        AverageValueWinningBidResponse result = averageValueWinningBidResponseMapper.maToResponse(null);

        //then
        Assertions.assertEquals(Double.NaN, result.getAverage());
    }
}