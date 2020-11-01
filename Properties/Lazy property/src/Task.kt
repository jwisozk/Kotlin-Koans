class LazyProperty(val initializer: () -> Int) {
    val _initializer = initializer
    var counter = 0
    var _lazy = 0
    val lazy: Int
        get() {
            if (counter == 0) {
                _lazy = _initializer()
                counter++
            }
            return _lazy
        }
}
