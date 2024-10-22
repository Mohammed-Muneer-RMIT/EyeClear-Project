package eyeclear.prescription;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private float axis;
    private String dateExamination;
    private String optometrist;
    private ArrayList<String> postRemarks = new ArrayList<>();

    // Constructor
    public Prescription(int id, String firstName, String lastName, String address, float sphere, float cylinder, float axis, String date, String optometrist) {
        this.prescID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
        this.dateExamination = date;
        this.optometrist = optometrist;
    }

    // Add prescription to text file
    public boolean addPrescription() {
        // Validate fields
        if (firstName.length() < 4 || firstName.length() > 15 || lastName.length() < 4 || lastName.length() > 15) {
            return false;
        }

        if (address.length() < 20) {
            return false;
        }

        if (sphere < -20.00 || sphere > 20.00) {
            return false;
        }

        if (cylinder < -4.00 || cylinder > 4.00) {
            return false;
        }

        if (axis < 0 || axis > 180) {
            return false;
        }

        if (optometrist.length() < 8 || optometrist.length() > 25) {
            return false;
        }

        // Save the prescription to a text file
        try {
            FileWriter writer = new FileWriter("presc.txt", true);
            writer.write("Prescription ID: " + prescID + "\n");
            writer.write("First Name: " + firstName + "\n");
            writer.write("Last Name: " + lastName + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Sphere: " + sphere + "\n");
            writer.write("Cylinder: " + cylinder + "\n");
            writer.write("Axis: " + axis + "\n");
            writer.write("Date of Examination: " + dateExamination + "\n");
            writer.write("Optometrist: " + optometrist + "\n");
            writer.write("------------------------------\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // Add a remark to the prescription
    public boolean addRemark(String remark, String category) {
        // Split the remark by spaces to count the words
        String[] words = remark.split("\\s+");

        // Check if the remark has at least 6 words and no more than 20 words
        if (words.length < 6 || words.length > 20) {
            System.out.println("Remark does not meet the word count condition.");
            return false;
        }

        // Check if the category is either "client" or "optometrist"
        if (!category.equals("client") && !category.equals("optometrist")) {
            System.out.println("Remark category is invalid.");
            return false;
        }

        // Check if there are already 2 remarks for this prescription
        if (postRemarks.size() >= 2) {
            System.out.println("This prescription already has 2 remarks.");
            return false;
        }

        // Add the remark if all conditions are met
        postRemarks.add(remark);
        System.out.println("Remark added successfully.");
        return true;
    }

}
