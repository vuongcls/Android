class PropertyExample() {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(tmp) {
            field = tmp
            counter ++
        }
}
