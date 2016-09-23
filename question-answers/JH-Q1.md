# 1

## a

The fault is at `if (x[i] >= 0)`. This line will cause the function to count all non-negative numbers rather than just positive numbers.

## b

Test case that will not execute the fault:
`x = [-4, 2, 2, 2]`

## c

Test case that will execute the fault without entering an error state:
`x = [-4, 0, 1, -1]`

## d

Test case that will cause an error without causing failure:
`x = []`

## e

First error state in `x = [-4, 2, 0, 2]`:
```
x.length = 4
i = 2
x[i] = 0
count = 2
```

Final count (expected): 2
Final count (actual): 3
