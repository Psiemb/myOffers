package myApplications.myOffers.mapper;

import myApplications.myOffers.dao.Month;
import myApplications.myOffers.dao.Offer;
import myApplications.myOffers.dao.Stage;
import myApplications.myOffers.response.NameRandomResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameRandomResponseMapperTest {

    private NameRandomResponseMapper nameRandomResponseMapper;

    @BeforeEach
    void setUp(){
        this.nameRandomResponseMapper = new NameRandomResponseMapper();
    }

    @Test
    public void checkIfObjectIsNull(){

        //when
        NameRandomResponse result = nameRandomResponseMapper.mapToResponse(null);

        //then /TODO dlaczego wyświetla mi błąd. Wydawało mi sie ż e w maperze zabezpieczało mnie Optional.ofNullable(offers) więc powinno zwrócić emptyList()
        Assertions.assertNull(result);

    }
    @Test
    public void checkIfNameIsNull(){
        //given
        List<Offer> offers = Arrays.asList(new Offer(LocalDate.now(), "For Activ", Month.JAN, 5000000, Stage.IN_PREPARATION, true, null),
                new Offer(LocalDate.now(), "For Swietelsky", Month.JAN, 1500000, Stage.SENT, true,null));

        //when
        NameRandomResponse result = nameRandomResponseMapper.mapToResponse(offers);

        //then
        Assertions.assertNotNull(result);

    }

    @Test
    public void checkIfNameIsRandom(){
        //given
        List<Offer> offers = Arrays.asList(new Offer(LocalDate.now(), "For Activ", Month.JAN, 5000000, Stage.IN_PREPARATION, true, "Piotr"));
                //when
        NameRandomResponse result = nameRandomResponseMapper.mapToResponse(offers);

        //then
        Assertions.assertEquals("Piotr",result);

    }
}