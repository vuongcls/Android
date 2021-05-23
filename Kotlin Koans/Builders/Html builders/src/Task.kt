fun renderProductTable(): String {
    return html {
        table {
            tr(color = getTitleColor()) {}

            val products = getProducts()
            for ((i, p) in products.withIndex()) {
                tr {
                    td(color = getCellColor(i, 0)) {
                        text(p.description)
                    }
                    td(color = getCellColor(i, 1)) {
                        text(p.price)
                    }
                    td(color = getCellColor(i, 2)) {
                        text(p.popularity)
                    }
                }
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) % 2 == 0) "#dce4ff" else "#eff2ff"
