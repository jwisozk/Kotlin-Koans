// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    val ordersSequence = customer.orders.asSequence()
    return ordersSequence
            .filter { it.isDelivered }
            .flatMap {it.products.asSequence()}
            .maxBy(Product::price)
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    val customersSequence = customers.asSequence()
    return customersSequence
            .flatMap {it.getOrderedProducts()}
            .count{ it == product}
}

fun Customer.getOrderedProducts(): Sequence<Product> {
    val ordersSequence = orders.asSequence()
    return ordersSequence.flatMap { it.products.asSequence() }
}

