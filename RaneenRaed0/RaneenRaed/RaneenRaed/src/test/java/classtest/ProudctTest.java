package classtest;

import org.example.lists.ProudctList;
import org.example.model.Proudct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProudctTest {

    private Proudct testProduct;

    @BeforeEach
    void setUp() {
        // Initialize a test product before each test
        testProduct = new Proudct("TestProduct", 1, false, "20.99", "test.jpg");
        ProudctList.getProudctList().clear(); // Clear the product list before each test
        ProudctList.getProudctList().add(testProduct); // Add the test product to the list
    }

    @Test
    void testConstructor() {
        assertEquals("TestProduct", testProduct.getName());
        assertEquals(1, testProduct.getProudctId());
        assertFalse(testProduct.isReserve());
        assertEquals("20.99", testProduct.getPrice());
        assertEquals("test.jpg", testProduct.getPhoto());
    }

    @Test
    void testGettersAndSetters() {
        // Test getters and setters
        testProduct.setName("UpdatedProduct");
        assertEquals("UpdatedProduct", testProduct.getName());

        testProduct.setProudctId(2);
        assertNotEquals(2, testProduct.getProudctId());

        testProduct.setReserve(true);
        assertTrue(testProduct.isReserve());

        testProduct.setPrice("25.99");
        assertEquals("25.99", testProduct.getPrice());

        testProduct.setPhoto("updated.jpg");
        assertEquals("updated.jpg", testProduct.getPhoto());
    }

    @Test
    void testSetHouseId() {
        testProduct.setHouseId(3);
        assertEquals(3, testProduct.getProudctId());
    }

    @Test
    void testInteractionWithProudctList() {
        // Verify the product is added to the list
        assertEquals(1, ProudctList.getProudctList().size());
        assertTrue(ProudctList.getProudctList().contains(testProduct));

        // Add another product to the list
        Proudct anotherProduct = new Proudct("AnotherProduct", 2, true, "30.99", "another.jpg");
        ProudctList.getProudctList().add(anotherProduct);

        // Verify the list size and contents
        assertEquals(2, ProudctList.getProudctList().size());
        assertTrue(ProudctList.getProudctList().contains(testProduct));
        assertTrue(ProudctList.getProudctList().contains(anotherProduct));

        // Remove the test product from the list
        ProudctList.getProudctList().remove(testProduct);

        // Verify the list size and contents after removal
        assertEquals(1, ProudctList.getProudctList().size());
        assertFalse(ProudctList.getProudctList().contains(testProduct));
        assertTrue(ProudctList.getProudctList().contains(anotherProduct));
    }
}
