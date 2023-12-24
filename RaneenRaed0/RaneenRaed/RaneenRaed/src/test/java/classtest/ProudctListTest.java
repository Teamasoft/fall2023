package classtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.model.Proudct;
import org.example.lists.ProudctList;

import java.util.ArrayList;
import java.util.List;

class ProudctListTest {

    private List<Proudct> originalProudctList;

    @BeforeEach
    void setUp() {
        // Save the original ProudctList before each test
        originalProudctList = new ArrayList<>(ProudctList.getProudctList());
    }

    @Test
    void testGetProudctList() {
        List<Proudct> proudctList = ProudctList.getProudctList();
        assertNotNull(proudctList);
        assertEquals(originalProudctList, proudctList);
    }

    @Test
    void testAddProudct() {
        Proudct newProudct = new Proudct("Laptop", 1, true, "$1000", "laptop.jpg");
        ProudctList.addProudct(newProudct);

        List<Proudct> updatedProudctList = ProudctList.getProudctList();
        assertNotNull(updatedProudctList);
        assertTrue(updatedProudctList.contains(newProudct));
    }

    // Add more tests as needed based on your requirements

    // ...

}
