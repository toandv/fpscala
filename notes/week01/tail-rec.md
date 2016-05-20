## Tail recursion in Scala

```scala
def factorial(n: Int): Int = {
  @tailrec
  def loop(acc: Int, n: Int): Int = if (n <= 0) acc else loop(n * acc, n - 1)
  loop(1, n)
}
```

By putting the @tailrec annotation on the method loop, the Scala compiler will translate the this 
method into a new version using loop. It would be someting like following:

```scala
def loop1(acc: Long, n: Long): Long = {
  var acc1 = acc
  var n1 = n
  while (n1 > 0) {
    acc1 = acc1 * n1
    n1 = n1 - 1
  }
  acc1
}
```

## Tail recursion
If a function calls itself as its last action, the function's stack frame can be reused, this is call tail recursion.
=> Tail recursive functions are iterative processes
If the last action of a function consists of a calling a function (which is may the same), on stack frame is sufficient
for both functions.
Such calls are called tail-calls

// TODO

http://blog.richdougherty.com/2009/04/tail-calls-tailrec-and-trampolines.html

