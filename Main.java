import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HospitalService hs = new HospitalService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- HOSPITAL MANAGEMENT SYSTEM ---");
            System.out.println("1 Add Patient");
            System.out.println("2 View Patients");
            System.out.println("3 Search Patient");
            System.out.println("4 Update Patient");
            System.out.println("5 Delete Patient");
            System.out.println("6 Add Doctor");
            System.out.println("7 View Doctors");
            System.out.println("8 Book Appointment");
            System.out.println("9 View Appointments");
            System.out.println("10 Exit");

            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 : hs.addPatient();
                case 2 : hs.viewPatients();
                case 3 : hs.searchPatient();
                case 4 : hs.updatePatient();
                case 5 : hs.deletePatient();
                case 6 : hs.addDoctor();
                case 7 : hs.viewDoctors();
                case 8 : hs.bookAppointment();
                case 9 : hs.viewAppointments();
                case 10 : { System.out.println("Thank You!"); return; }
                default : System.out.println("Invalid Choice");
            }
        }
    }
}