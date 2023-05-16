import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repository = new ShopRepository();
    Product product1 = new Product(1, "Телефон", 1000);
    Product product2 = new Product(2, "Зарядка", 100);
    Product product3 = new Product(3, "Кабель", 10);
    Product product4 = new Product(4, "Переходник", 10);
    Product product5 = new Product(5, "Флешка", 500);

    @BeforeEach
    public void setup() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
    }

    @Test
    public void shouldRemoveByIdExistingElement() {
        repository.removeById(3);
        Product[] expected = {product1, product2, product4, product5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNonExistentElement() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(7);
        });
    }

}