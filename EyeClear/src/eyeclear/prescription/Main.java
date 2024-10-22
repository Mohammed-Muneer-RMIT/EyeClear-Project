package eyeclear.prescription;

public class Main {

	public static void main(String[] args) {
		
		Prescription presc = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Andrew");

        // Test the addPrescription method
        boolean isPrescriptionAdded = presc.addPrescription();
        if (isPrescriptionAdded) {
            System.out.println("Prescription added successfully!");
        } else {
            System.out.println("Prescription did not meet the required conditions.");
        }

        // Test the addRemark method
        boolean isRemarkAdded = presc.addRemark("Excellent service and friendly staff. Highly recommended.", "client");
        if (isRemarkAdded) {
            System.out.println("Remark added successfully!");
        } else {
            System.out.println("Remark did not meet the required conditions.");
        }
        
        Prescription presc1 = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Andrew");
        boolean result1 = presc1.addPrescription();
        System.out.println("Test 1 (valid prescription): " + result1);  // Expected output: true

        // Test case 2: Invalid prescription (First name too short)
        Prescription presc2 = new Prescription(2, "Tom", "Smith", "123 Main St, Suburb, 12345, Country", 2.5f, -1.25f, 90, "22/10/2024", "Dr. Andrew");
        boolean result2 = presc2.addPrescription();
        System.out.println("Test 2 (invalid prescription - first name too short): " + result2);  // Expected output: false

	}

}
