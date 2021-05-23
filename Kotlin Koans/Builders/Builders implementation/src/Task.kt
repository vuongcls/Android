open class Tag(val name: String) {
    protected val children = mutableListOf<Tag>()

    override fun toString() =
            "<$name>${children.joinToString("")}</$name>"
}

fun table(init: TABLE.() -> Unit): TABLE {
    val table = TABLE()
    table.init()
    return table
}

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) {
        val t = TR()
        t.init()
        children += t
    }
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) {
        children += TD().apply(init)
    }
}

class TD : Tag("td")

fun createTable() =
        table {
            tr {
                repeat(2) {
                    td {
                    }
                }
            }
        }

fun main() {
    println(createTable())
}