package myApplications.myOffers.dao;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class OfferDataBase {

    private List<Offer> offers = createOffers();

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    private List<Offer> createOffers() {
        List<Offer> result = new ArrayList<>();
        result.add(new Offer(LocalDate.now(), "For Activ", Month.JAN, 5000000, Stage.IN_PREPARATION, true, "Wiesiek"));
        result.add(new Offer(LocalDate.now(), "For KGGroup", Month.FEB, 4000000, Stage.PREPARED, true, "Andrzej"));
        result.add(new Offer(LocalDate.now(), "For Gulermack", Month.FEB, 8000000, Stage.PREPARED, false, "Kamila"));
        result.add(new Offer(LocalDate.now(), "For Unibep", Month.FEB, 3500000, Stage.INQUIRY, false, "Piotr"));
        result.add(new Offer(LocalDate.now(), "For KZN", Month.JAN, 7000000, Stage.PREPARED, false, "Szymon"));
        result.add(new Offer(LocalDate.now(), "For Swietelsky", Month.JAN, 1500000, Stage.SENT, true, "Halina"));

        return result;
    }
}
