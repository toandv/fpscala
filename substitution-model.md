# Substituion-model

https://class.coursera.org/progfun-004/lecture/3

## Call-by-value and Call-by-name

Both evaluation strategies reduce to the same final value as long as:
* the reduced expression consists of pure functions
* both evaluations terminate

All the arguments passed to a function are reduces to values, ex: an expression is reduced to a value.

*Call-by-value* has the advantage that every function argument is evaluated once.

*Call-by-name* has the advantage that a function argument is not evaluated if the conrresponding argument is unused
in the evaluation of function body.


We have a function:

```scala
  def test(x: Int, y: Int) = x * x
```

*Call-by-value*
```scala
// 1 => 4 steps
test(3 + 4, 8) // (3 + 4) is only evaluated once
test(7, 8)
7 * 7
49

// 2 => 4 steps
test(7, 2 * 4) // (2 * 4) is evaluated but is never used
test(7, 8)
7 * 7
49

// 3 => 5 steps
test(3 + 4, 2 * 4)
test(7, 2 * 4)
test(7, 8)
7 * 7
49
```
*Call-by-name*
```scala
// 1 => 5 steps
test(3 + 4, 8)
(3 + 4) * (3 + 4) // (3 + 4) is evaluated twice
7 * (3 + 4)
7 * 7
49

// 2 => 3 steps
test(7, 2 * 4) // (2 * 4) is not evaluated 
7 * 7
49

// 3 => 5 steps
test(3 + 4, 2 * 4)
(3 + 4) * (3 + 4)
7 * (3 + 4)
7  * 7
49
```
Both produce the same result.

