package myApplications.myOffers.response;

public class NameRandomResponse {

    private String name;

    public NameRandomResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NameRandomResponse{" +
                "name='" + name + '\'' +
                '}';
    }
}
