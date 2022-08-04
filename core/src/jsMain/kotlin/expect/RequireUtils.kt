package expect

external fun <T> require(module: String): T

fun <T> requireFromRootDir(path: String) = require<T>("../../../../../$path")