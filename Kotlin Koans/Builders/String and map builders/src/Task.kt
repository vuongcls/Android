import java.util.HashMap

fun <key, value> buildMap(build: HashMap<key, value>.() -> Unit): Map<key, value> {
    val map = HashMap<key, value>()
    map.build()
    return map
}

fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
