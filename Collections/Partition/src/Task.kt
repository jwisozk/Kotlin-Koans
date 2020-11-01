// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
        customers.filter {
            val orders = it.orders
            val (match, rest) = orders.partition { it.isDelivered }
            match.size < rest.size
        }.toSet()
