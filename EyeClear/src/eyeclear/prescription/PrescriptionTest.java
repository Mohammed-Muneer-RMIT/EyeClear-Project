package eyeclear.prescription;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PrescriptionTest {

    @Test
    void testAddPrescription() {
        Prescription presc = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Optometrist");
        boolean result = presc.addPrescription();
        assertTrue(result, "Prescription should be added successfully.");
    }

    @Test
    void testInvalidPrescription() {
        Prescription presc = new Prescription(2, "T", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Optometrist");
        boolean result = presc.addPrescription();
        assertFalse(result, "Prescription should fail due to short first name.");
    }

    @Test
    void testInvalidPrescriptionAddress() {
        Prescription presc = new Prescription(3, "John", "Smith", "", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Optometrist");
        boolean result = presc.addPrescription();
        assertFalse(result, "Prescription should fail due to missing address.");
    }

    @Test
    void testInvalidPrescriptionSphere() {
    	Prescription presc = new Prescription(4, "John", "Smith", "123 Main St, Suburb, 12345, Country", 25.0f, -1.25f, 90, "22/10/2024", "Dr. Optometrist");
    	boolean result = presc.addPrescription();
    	assertFalse(result, "Prescription should fail due to invalid sphere.");

    }

    @Test
    void testValidPrescriptionLongAddress() {
        Prescription presc = new Prescription(5, "John", "Smith", "123 Long Street Name, Suburb, 12345", 2.0f, -2.0f, 90, "22/10/2024", "Dr. Optometrist");
        boolean result = presc.addPrescription();
        assertTrue(result, "Prescription should be added successfully.");
    }

    @Test
    void testInvalidPrescriptionDate() {
        Prescription presc = new Prescription(6, "John", "Smith", "123 Main St, Suburb, 12345, Country", 1.5f, -1.0f, 90, "Invalid Date", "Dr. Optometrist");
        boolean result = presc.addPrescription();
        assertTrue(result, "Prescription should fail due to invalid date.");
    }

    @Test
    void testAddRemark() {
        Prescription presc = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Optometrist");
        boolean result = presc.addRemark("Excellent service, very professional and friendly staff.", "client");
        assertTrue(result, "Remark should be added successfully.");
    }

    @Test
    void testInvalidRemarkTooShort() {
        Prescription presc = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Optometrist");
        boolean result = presc.addRemark("Too short", "client");
        assertFalse(result, "Remark should fail due to being too short.");
    }

    @Test
    void testInvalidRemarkExceedsLimit() {
        Prescription presc = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Optometrist");
        String longRemark = "This is a very long remark that exceeds the word count limit for the system and should not be accepted at all.";
        boolean result = presc.addRemark(longRemark, "client");
        assertFalse(result, "Remark should fail due to exceeding the word count.");
    }

    @Test
    void testInvalidCategory() {
        Prescription presc = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Optometrist");
        boolean result = presc.addRemark("Great service!", "invalidCategory");
        assertFalse(result, "Remark should fail due to invalid category.");
    }

    @Test
    void testTooManyRemarks() {
        Prescription presc = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Optometrist");
        presc.addRemark("Remark 1", "client");
        presc.addRemark("Remark 2", "client");
        boolean result = presc.addRemark("Remark 3", "client");
        assertFalse(result, "Remark should fail because there are already 2 remarks.");
    }
}
