package ua.kpi.arturo.patterns.three_builder;

public class Main {

    public static void main(String... args) {
        TourOperator operator = new TourOperator();

        operator.setTourBuilder(new MexicoTourBuilder());
        Tour mexicoTour = operator.buildTour();
        System.out.println(mexicoTour);

        operator.setTourBuilder(new NewYorkTourBuilder());
        Tour newYorkTour = operator.buildTour();
        System.out.println(newYorkTour);
    }
}

enum Transfer {
    CAR, BUS
}

enum FlightLevel {
    ECONOMY, STANDARD, BUSINESS
}

enum HotelType {
    ECONOMY, STANDARD, LUX
}

class Tour {

    Transfer transfer;
    FlightLevel flightLevel;
    HotelType hotelType;
    boolean insurance;

    void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    void setFlightLevel(FlightLevel flightLevel) {
        this.flightLevel = flightLevel;
    }

    void setHotelType(HotelType hotelType) {
        this.hotelType = hotelType;
    }

    void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "Tour{" +
            "transfer=" + transfer +
            ", flightLevel=" + flightLevel +
            ", hotelType=" + hotelType +
            ", insurance=" + insurance +
            '}';
    }
}

abstract class TourBuilder {

    Tour tour;

    void createTour() {
        tour = new Tour();
    }

    abstract void addTransfer();

    abstract void addFlightLevel();

    abstract void addHotelType();

    abstract void addInsurance();

    Tour build() {
        return tour;
    }
}

class MexicoTourBuilder extends TourBuilder {

    @Override
    void addTransfer() {
        tour.setTransfer(Transfer.BUS);
    }

    @Override
    void addFlightLevel() {
        tour.setFlightLevel(FlightLevel.STANDARD);
    }

    @Override
    void addHotelType() {
        tour.setHotelType(HotelType.STANDARD);
    }

    @Override
    void addInsurance() {
        tour.setInsurance(false);
    }
}

class NewYorkTourBuilder extends TourBuilder {

    @Override
    void addTransfer() {
        tour.setTransfer(Transfer.CAR);
    }

    @Override
    void addFlightLevel() {
        tour.setFlightLevel(FlightLevel.BUSINESS);
    }

    @Override
    void addHotelType() {
        tour.setHotelType(HotelType.LUX);
    }

    @Override
    void addInsurance() {
        tour.setInsurance(true);
    }
}

class TourOperator {

    TourBuilder tourBuilder;

    void setTourBuilder(TourBuilder tourBuilder) {
        this.tourBuilder = tourBuilder;
    }

    Tour buildTour() {
        tourBuilder.createTour();
        tourBuilder.addTransfer();
        tourBuilder.addFlightLevel();
        tourBuilder.addHotelType();
        tourBuilder.addInsurance();
        return tourBuilder.build();
    }
}
