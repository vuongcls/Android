// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> = customers.filter {
    val (deliv, undel) = it.orders.partition { it.isDelivered }
    undel.size > deliv.size
}.toSet()
