package chbs;

import chbs.objectDir.Committee;
import chbs.objectDir.MyCustomer;

public class CHBS {
    public static FirstScreen firstScreen = new FirstScreen();
    public static UserAuth userAuth = new UserAuth();
    public static UserAccountScreen second = new UserAccountScreen();

    public static CommitteeAuth third = new CommitteeAuth();
    public static CommitteeRoute committeeRoute = new CommitteeRoute();
    public static CommitteeBookingManage committeeBookingManage = new CommitteeBookingManage();
    public static CommitteeUserManage committeeUserManage = new CommitteeUserManage();
    public static CommitteeManagement committeeManagement = new CommitteeManagement();
    public static VaccineManagement vaccineManagement = new VaccineManagement();
    public static StatisticalReport statisticalReport = new StatisticalReport();

    public static MyCustomer login;
    public static Committee committee;

    public static void main(String[] args) {
        DataIO.read();
    }
}
