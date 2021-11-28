package chbs;

public class CHBS {
    public static Page main = new Page();
    public static Page1First first = new Page1First();
    public static Page2 second = new Page2();
    public static Page3 third = new Page3();
    // public static CommitteeScreen committeeScreen = new CommitteeScreen();
    public static CommitteeRoute committeeRoute = new CommitteeRoute();
    public static CommitteeBookingManage committeeBookingManage = new CommitteeBookingManage();
    public static CommitteeUserManage committeeUserManage = new CommitteeUserManage();
    public static MyCustomer login;
    public static Committee committee;

    public static void main(String[] args) {
        DataIO.read();
    }
}
