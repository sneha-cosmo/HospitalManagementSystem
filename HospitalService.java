import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

public class HospitalService {

    MongoDatabase db = MongoDBConnection.getDatabase();

    MongoCollection<Document> patientCol = db.getCollection("patients");
    MongoCollection<Document> doctorCol = db.getCollection("doctors");
    MongoCollection<Document> appointmentCol = db.getCollection("appointments");

    Scanner sc = new Scanner(System.in);

    // PATIENT
    public void addPatient() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Disease: ");
        String disease = sc.nextLine();

        patientCol.insertOne(new Document("id", id)
                .append("name", name)
                .append("age", age)
                .append("disease", disease));

        System.out.println("Patient Added Successfully!");
    }

    public void viewPatients() {
        for (Document d : patientCol.find()) {
            System.out.println(
                    d.getInteger("id") + " | " +
                    d.getString("name") + " | " +
                    d.getInteger("age") + " | " +
                    d.getString("disease")
            );
        }
    }

    public void searchPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        Document d = patientCol.find(eq("id", id)).first();
        System.out.println(d != null ? d : "Patient Not Found");
    }

    public void updatePatient() {
        System.out.print("Patient ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("New Name: ");
        String name = sc.nextLine();
        System.out.print("New Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("New Disease: ");
        String disease = sc.nextLine();

        var res = patientCol.updateOne(eq("id", id),
                combine(set("name", name),
                        set("age", age),
                        set("disease", disease)));

        System.out.println(res.getMatchedCount() > 0 ?
                "Updated Successfully!" : "Patient Not Found");
    }

    public void deletePatient() {
        System.out.print("Patient ID: ");
        int id = sc.nextInt();
        var res = patientCol.deleteOne(eq("id", id));
        System.out.println(res.getDeletedCount() > 0 ?
                "Deleted Successfully!" : "Patient Not Found");
    }

    // DOCTOR
    public void addDoctor() {
        System.out.print("Doctor ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Specialization: ");
        String sp = sc.nextLine();

        doctorCol.insertOne(new Document("id", id)
                .append("name", name)
                .append("specialization", sp));

        System.out.println("Doctor Added!");
    }

    public void viewDoctors() {
        for (Document d : doctorCol.find()) {
            System.out.println(
                    d.getInteger("id") + " | " +
                    d.getString("name") + " | " +
                    d.getString("specialization")
            );
        }
    }

    // APPOINTMENT
    public void bookAppointment() {
        System.out.print("Patient ID: ");
        int pid = sc.nextInt();
        System.out.print("Doctor ID: ");
        int did = sc.nextInt(); sc.nextLine();
        System.out.print("Date: ");
        String date = sc.nextLine();

        appointmentCol.insertOne(new Document("patientId", pid)
                .append("doctorId", did)
                .append("date", date));

        System.out.println("Appointment Booked!");
    }

    public void viewAppointments() {
        for (Document d : appointmentCol.find()) {
            System.out.println(
                    "Patient: " + d.getInteger("patientId") +
                    " | Doctor: " + d.getInteger("doctorId") +
                    " | Date: " + d.getString("date")
            );
        }
    }
}