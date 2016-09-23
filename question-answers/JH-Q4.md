# 4

| Line | Bug Overview (part a) | Solution (part b) |
| ---: |--------------|----------|
| 84 | Attempting to cast from `Double` to `Long` | Recast to `Double` |
| 96 | Attempting to cast `RuntimeError` as `SecurityError` | Do not recast as another type; instead, cast as type `RuntimeError` |
| 108 | `instanceof Long` on `Double` will always return false | Check against `Double`, not `Long` |
| 120 | Attempting to downcast a Collection to an Array | Use `.toArray()` parameter to set the type for the array |
| 133 | Loss of precision in cast from `Double` to `BigDecimal` | Use `BigDecimal.valueOf(double)` to retain precision |
| 147 | Comparing strings using `==`; May result in inaccurate results | Compare using `equals(obj)` instead |
| 159 | Invalid formatting syntax | move `>` between formatting symbols |
| 168 | Return value of `BigDecimal.add()` ignored; function does not update variable | Assign return value to a variable |
| 198 | Attempting assignment in comparison | Change `=` to `==` |
