package com.pruebasoftware.semana4.pedidos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    @Test
    void subtotalMultipliesUnitPriceByQuantity() {
        OrderItem item = new OrderItem("Cuaderno", 4, new BigDecimal("5.50"));

        BigDecimal subtotal = item.subtotal();

        assertEquals(0, new BigDecimal("22.00").compareTo(subtotal));
    }

    @Test
    void totalAddsAllItemSubtotals() {
        Order order = new Order(
                "order-1",
                "Carlos Ruiz",
                List.of(
                        new OrderItem("Cuaderno", 2, new BigDecimal("5.50")),
                        new OrderItem("Lapicero", 3, new BigDecimal("1.20"))
                ),
                LocalDateTime.of(2026, 9, 5, 10, 0)
        );

        BigDecimal total = order.total();

        assertEquals(0, new BigDecimal("14.60").compareTo(total));
    }
}
