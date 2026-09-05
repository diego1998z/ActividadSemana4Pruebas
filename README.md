# PRUEBASOFTWARE-SEMANA4

Laboratorio de CI/CD con pruebas automatizadas en Java 17, Maven y JUnit 5.

## Propuestas implementadas

### 1. Biblioteca

Clases principales:

- `Loan`: representa un préstamo de biblioteca y calcula los días de retraso.
- `LoanRepository`: contrato de persistencia.
- `InMemoryLoanRepository`: repositorio en memoria para pruebas e integración simple.
- `LoanService`: caso de uso para registrar y consultar préstamos.

Pruebas:

- Unitarias: cálculo de días de retraso.
- Integración: registro y recuperación de préstamos usando `LoanService` + `InMemoryLoanRepository`.

### 2. Pedidos

Clases principales:

- `Order`: representa un pedido y calcula el total.
- `OrderItem`: representa un ítem del pedido y calcula su subtotal.
- `OrderRepository`: contrato de persistencia.
- `InMemoryOrderRepository`: repositorio en memoria para pruebas e integración simple.
- `OrderService`: caso de uso para registrar y consultar pedidos.

Pruebas:

- Unitarias: cálculo del total del pedido.
- Integración: registro y recuperación de pedidos usando `OrderService` + `InMemoryOrderRepository`.

## Cómo ejecutar las pruebas localmente

> En esta implementación no se ejecutó build ni paquete final. Para cumplir la guía, el comando recomendado es solo pruebas.

```bash
mvn test
```

No usar para este laboratorio si la consigna prohíbe build:

```bash
mvn package
mvn install
```

## Pipeline CI/CD

El workflow está en:

```text
.github/workflows/ci.yml
```

Se ejecuta automáticamente en:

- `push`
- `pull_request`

Pasos del pipeline:

1. Descarga el repositorio.
2. Configura Java 17 con distribución Temurin.
3. Ejecuta `mvn test`.

## Fallo controlado sugerido

Para demostrar que el pipeline detecta errores, se puede hacer una rama temporal y modificar una aserción de una prueba. Por ejemplo:

- En `OrderTest`, cambiar el total esperado de `14.60` a `15.00`.
- Subir la rama a GitHub.
- Verificar que GitHub Actions marque el workflow como fallido.
- Revertir el cambio y confirmar que el pipeline vuelve a pasar.

No dejar el fallo controlado en la rama final.

## Evidencias sugeridas

Guardar capturas o logs en la carpeta `evidencias/`:

- Captura del comando `mvn test` ejecutado localmente.
- Captura del workflow exitoso en GitHub Actions.
- Captura del fallo controlado.
- Captura del pipeline corregido después de revertir el fallo.

También se puede copiar el enlace del workflow de GitHub Actions en `evidencias/README.md`.

## Conclusión

El laboratorio demuestra una base mínima de CI/CD: dos propuestas propias con reglas de negocio simples, pruebas unitarias, pruebas de integración y un pipeline automatizado que valida la calidad en cada push o pull request.
