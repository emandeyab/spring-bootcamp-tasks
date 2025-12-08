import com.springApp.model.Product;
import com.springApp.model.ProductDetails;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductApisTest {
    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    public void insertNewProductTest() {
        Product product = new Product();
        product.setName("Electronics");

        ProductDetails productDetails = new ProductDetails();
        productDetails.setName("Mobile Phone");
        productDetails.setManufacturer("Samsung");
        productDetails.setPrice(15000);
        productDetails.setAvailable(true);
        productDetails.setExpirationDate(LocalDate.parse("2025-12-20"));
        productDetails.setProduct(product);

        String url = "http://localhost:8080/ProductApis/api/products/details";
        ResponseEntity<ProductDetails> response = restTemplate.postForEntity(url, productDetails, ProductDetails.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void updateProductTest() {
        String url = "http://localhost:8080/ProductApis/api/products/details/17";
        ResponseEntity<ProductDetails> response = restTemplate.getForEntity(url, ProductDetails.class);

        ProductDetails productDetails = response.getBody();
        productDetails.setName("updated");
        productDetails.setManufacturer("updated");
        productDetails.setPrice(20000);

        ResponseEntity<ProductDetails> putResponce = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(productDetails),
                ProductDetails.class
        );

        assertEquals(HttpStatus.OK, putResponce.getStatusCode());
    }

    @Test
    public void deleteProductTest() {
        String url = "http://localhost:8080/ProductApis/api/products/17";
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        System.out.println("product deleted successfully");
    }

    @Test
    public void getProductByIdTest() {
        String url = "http://localhost:8080/ProductApis/api/products/1";
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println("Product Name: " + response.getBody().getName());
    }

    @Test
    public void getProductDetailsByIdTest() {
        String url = "http://localhost:8080/ProductApis/api/products/details/1";
        ResponseEntity<ProductDetails> response = restTemplate.getForEntity(url, ProductDetails.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println("Product Name: " + response.getBody().getName());
    }

    @Test
    public void getAllProductsTest() {
        String url = "http://localhost:8080/ProductApis/api/products";
        ResponseEntity<Product[]> response = restTemplate.getForEntity(url, Product[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        for (Product p : response.getBody()) {
            System.out.println("Product: " + p.getName());
        }
    }

    @Test
    public void getProductDetailsByName() {
        String url = "http://localhost:8080/ProductApis/api/products/details/name/Brown Bread";
        ResponseEntity<ProductDetails> response = restTemplate.getForEntity(url, ProductDetails.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        System.out.println("Product Name: " + response.getBody().getName()
        + ", Manufacturer: " + response.getBody().getManufacturer()
        + ", Price: " + response.getBody().getPrice());
    }

}
