package com.pruebasoftware.semana4.pedidos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderServiceIntegrationTest {
    @Test
    void registerOrderPersistsItInRepository() {
        OrderRepository repository = new InMemoryOrderRepository();
        OrderService service = new OrderService(repository);

        service.registerOrder(
                "order-100",
                "Sofia Vega",
                List.of(
                        new OrderItem("Teclado", 1, new BigDecimal("80.00")),
                        new OrderItem("Mouse", 2, new BigDecimal("25.00"))
                )
        );

        Optional<Order> savedOrder = service.findOrder("order-100");

        assertTrue(savedOrder.isPresent());
        assertEquals("Sofia Vega", savedOrder.get().getCustomerName());
        assertEquals(0, new BigDecimal("130.00").compareTo(savedOrder.get().total()));
    }
}
