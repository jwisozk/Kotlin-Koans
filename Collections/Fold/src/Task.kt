// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val orderedProducts = customers.flatMap(Customer::getOrderedProducts).toSet()
    return customers.fold(orderedProducts, { orderedByAll, customer ->
                orderedByAll.intersect(customer.getOrderedProducts())
            })
}

fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products }