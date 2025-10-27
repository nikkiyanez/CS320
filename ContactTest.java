import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("12345", "Nikki", "Yanez", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactId());
        assertEquals("Nikki", contact.getFirstName());
        assertEquals("Yanez", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "Maria", "Marko", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "Maria", "Marko", "1234567890", "123 Main St"));
    }

    @Test
    void testSettersWorkCorrectly() {
        Contact contact = new Contact("123", "Anya", "Dennison", "1234567890", "123 Main St");
        contact.setFirstName("Jacqui");
        contact.setLastName("Putrino");
        contact.setPhone("0987654321");
        contact.setAddress("6090 Elm St");

        assertEquals("Jacqui", contact.getFirstName());
        assertEquals("Putrino", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("6090 Elm St", contact.getAddress());
    }

    @Test
    void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("111", "Janice", "Daper", "12345", "123 Main St"));
    }
}
