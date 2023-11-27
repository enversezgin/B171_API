package pojos.herokuapp;

public class BookingDatesPojo {
    private String checkin;
    private String checkout;

    public BookingDatesPojo() {
    }           // (parametresiz constructor oluşturulur) sağ tık --> Generate --> Constructor --> Select None

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }           // (parametreli constructor oluşturulur) sağ tık --> Generate --> Constructor --> Select All

                // (getter and setter oluşturulur)
                // sağ tık --> Generate --> Constructor --> Getter and Setter
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

                // (to String oluşturulur) sağ tık --> Generate --> to String () --> Select All
    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}