package pojos;

public class POJO_expBodyPojo_JPH {
    private int bookingId;
    private POJO_RequestBodyPojo_JPH booking;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public POJO_RequestBodyPojo_JPH getBooking() {
        return booking;
    }

    public void setBooking(POJO_RequestBodyPojo_JPH booking) {
        this.booking = booking;
    }

    public POJO_expBodyPojo_JPH(int bookingId, POJO_RequestBodyPojo_JPH booking) {
        this.bookingId = bookingId;
        this.booking = booking;
    }

    public POJO_expBodyPojo_JPH() {
    }

    @Override
    public String toString() {
        return "POJO_expBodyPojo_JPH{" +
                "bookingId=" + bookingId +
                ", booking=" + booking +
                '}';
    }
}
