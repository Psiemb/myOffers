package myApplications.myOffers.dao;

import java.time.LocalDate;
import java.util.Objects;

public class Offer {

    private LocalDate localDate;
    private String description;
    private Month month;
    private double value1;
    private Stage stage;
    private boolean winningBid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Offer(LocalDate localDate, String description, Month month, double value1, Stage stage, boolean winningBid, String name) {
        this.localDate = localDate;
        this.month = month;
        this.description = description;
        this.value1 = value1;
        this.stage = stage;
        this.winningBid = winningBid;
        this.name = name;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getDescription() {
        return description;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isWinningBid() {
        return winningBid;
    }

    public void setWinningBid(boolean winningBid) {
        this.winningBid = winningBid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;
        Offer offer = (Offer) o;
        return Double.compare(offer.value1, value1) == 0 &&
                winningBid == offer.winningBid &&
                localDate.equals(offer.localDate) &&
                description.equals(offer.description) &&
                month == offer.month &&
                stage == offer.stage &&
                name.equals(offer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDate, description, month, value1, stage, winningBid, name);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "localDate=" + localDate +
                ", description='" + description + '\'' +
                ", month=" + month +
                ", value1=" + value1 +
                ", stage=" + stage +
                ", winningBid=" + winningBid +
                ", name='" + name + '\'' +
                '}';
    }
}
