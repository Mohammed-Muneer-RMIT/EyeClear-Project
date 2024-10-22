package eyeclear.prescription;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PrescriptionTest {

    @Test
    void testAddPrescription() {
        Prescription presc = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Andrew");
        boolean result = presc.addPrescription();
        assertTrue(result, "Prescription should be added successfully.");
    }

    @Test
    void testInvalidPrescription() {
        Prescription presc = new Prescription(2, "Tom", "Smith", "123 Main St", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Andrew");
        boolean result = presc.addPrescription();
        assertFalse(result, "Prescription should fail due to short first name.");
    }

    @Test
    void testAddRemark() {
        Prescription presc = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Andrew");
        boolean result = presc.addRemark("Excellent service, very professional and friendly staff.", "client");
        assertTrue(result, "Remark should be added successfully.");
    }


    @Test
    void testInvalidRemark() {
        Prescription presc = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Andrew");
        boolean result = presc.addRemark("Short.", "client");
        assertFalse(result, "Remark should fail due to short length.");
    }
}
