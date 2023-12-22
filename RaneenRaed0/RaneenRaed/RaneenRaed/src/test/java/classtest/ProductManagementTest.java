package classtest;

import org.example.lists.ProudctList;
import org.example.model.Proudct;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.admainoptions.ProductManagement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProductManagementTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

        // Reset the ProudctList before each test
        ProudctList.getProudctList().clear();
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void testAddProduct() {
        // Simulate user input
       // String input = "1\nTestProduct\n123\ntrue\n10.99\nproduct.jpg\n0\n";
       // System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Redirect logs to capture log messages
      //  Logger logger = Logger.getLogger(ProductManagement.class.getName());
       // Handler[] handlers = logger.getHandlers();
       // for (Handler handler : handlers) {
        //    handler.setLevel(Level.ALL);
        }

        // Run the manageProducts method
       // ProductManagement.manageProducts();

        // Check if the product was added
       // List<Proudct> productList = ProudctList.getProudctList();
       // assertNotEquals(1, productList.size());
       // assertNotEquals("TestProduct", productList.get(0).getName());

        // Check if log messages contain expected output
     //   String logs = outputStreamCaptor.toString();
        //assertNotEquals(true, logs.contains("Product added successfully!"));
    }

    // Add more tests for modifyProduct, deleteProduct, showProductTable, etc.

