import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("12345", "Nikki", "Yanez", "1234567890", "123 Main St");
        service.addContact(contact);
    }

    @Test
    void testAddContact() {
        Contact newContact = new Contact("67890", "Anya", "Dennison", "0987654321", "6090 Elm St");
        service.addContact(newContact);
        assertEquals("Jane", service.getContact("67890").getFirstName());
    }

    @Test
    void testAddDuplicateContact() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    void testDeleteContact() {
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    @Test
    void testUpdateContactFields() {
        service.updateFirstName("12345", "Jacqui");
        service.updateLastName("12345", "Putrino");
        service.updatePhone("12345", "1112223333");
        service.updateAddress("12345", "1020 Oak Ave");

        Contact updated = service.getContact("12345");
        assertEquals("Jacqui", updated.getFirstName());
        assertEquals("Putrino", updated.getLastName());
        assertEquals("1112223333", updated.getPhone());
        assertEquals("1020 Oak Ave", updated.getAddress());
    }

    @Test
    void testDeleteNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99999"));
    }
}