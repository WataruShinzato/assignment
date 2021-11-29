package chbs;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class DataIO {
    public static ArrayList<MyCustomer> allCustomers =
            new ArrayList<MyCustomer>();
    public static ArrayList<Booking> allBookings = 
            new ArrayList<Booking>();
    public static ArrayList<Committee> allCommittee = 
            new ArrayList<Committee>(); 
    public static ArrayList<Vaccine> allvaccine = 
            new ArrayList<Vaccine>();               
    public static void read(){
        try{
            Scanner s = new Scanner(new File("people.txt"));  // scan people file and add to allcustomer array.
            while(s.hasNext()){
                String a = s.nextLine();
                int b = Integer.parseInt(s.nextLine());
                s.nextLine();
                MyCustomer c = new MyCustomer(a,b);
                allCustomers.add(c);
            }
            Scanner u = new Scanner(new File("committee.txt"));  // scan people file and add to allcustomer array.
            while(u.hasNext()){
                String name = u.nextLine();
                int password = Integer.parseInt(u.nextLine());
                u.nextLine();
                Committee committee = new Committee(name, password);
                allCommittee.add(committee);
            }
            Scanner t = new Scanner(new File("booking.txt"));  // scan booking file and add to allbookings array.
            while(t.hasNext()){
                int a = Integer.parseInt(t.nextLine());
                Consultant b = Consultant.valueOf(t.nextLine());
                Day c = Day.valueOf(t.nextLine());
                int d = Integer.parseInt(t.nextLine());
                boolean e = Boolean.parseBoolean(t.nextLine());
                MyCustomer f = DataIO.checking(t.nextLine());
                t.nextLine();
                Booking x = new Booking(a,b,c,d,e,f);
                allBookings.add(x);
                f.getMyBookings().add(x);
            }
        } catch(Exception e){                                   // Exception handling
            System.out.println("Error in read!");
        }
    }
    public static void write(){                                   // write people's information to people file from allcustomer array
        try {
                PrintWriter p = new PrintWriter("people.txt");
                for(int i=0; i<allCustomers.size(); i++){
                    p.println(allCustomers.get(i).getName());
                    p.println(allCustomers.get(i).getPassword());
                    p.println();
                }
                p.close();
                PrintWriter r = new PrintWriter("committee.txt");
                for(int i=0; i<allCommittee.size(); i++){
                    r.println(allCommittee.get(i).getName());
                    r.println(allCommittee.get(i).getPassword());
                    r.println();
                }
                r.close();
                PrintWriter s = new PrintWriter("vaccine.txt");
                for(int i=0; i<allvaccine.size(); i++){
                    s.println(allvaccine.get(i).getQuantity());
                    s.println(allvaccine.get(i).get());
                    s.println();
                }
                s.close();
                PrintWriter q = new PrintWriter("booking.txt");        // write booing information to booking file from alllbooking array
                for(int i=0; i<allBookings.size(); i++){
                    Booking j = allBookings.get(i);
                    q.println(j.getId());
                    q.println(j.getConsultant());
                    q.println(j.getDay());
                    q.println(j.getTime());
                    q.println(j.isPaid());
                    q.println(j.getOnwer().getName());
                    q.println();
                }
                q.close();
        } catch(Exception e){                                    // Exception handling
            System.out.println("Error in write!");
        }
    }
    public static MyCustomer checking(String x){                 // checking method
        for(MyCustomer c : allCustomers){
            if(x.equals(c.getName())){
                return c;
            }
        }
        return null;
    }

    public static Booking findBookingByid(Boolean argIsPaid) {        // find specific booking by id
        for (Booking myBook : CHBS.login.getMyBookings()) {
            if (myBook.isPaid() == argIsPaid) {
                return myBook;
            }
        }
        return null;
    }
    public static Committee checkingCommittee(String name){   
        for(Committee committee : allCommittee) {
            if(name.equals(committee.getName())){
                return committee;
            }
        }
        return null;
    }
}
