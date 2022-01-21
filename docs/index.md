## Functions

To define a mathematical function, start with defining a variable(s). Then,
you can use mathematical notation to create a function:

```scala
import eu.shooktea.eureka.func._
import eu.shooktea.eureka.extension.AllExtensions._

val x = Variable()
val f = x * 2 + 5

val result = f(x -> 15)
println(result) // 35
```

Nothing stops you from defining a multi-variable function, too:

```scala
val x = Variable()
val y = Variable()
val f = 3 + x * y

val result = f(x -> -2.5, y -> 4)
println(result) // -7
```

Internally, all constants are converted into `BigDecimal` objects. All function calls also return a `BigDecimal`.
Importing `AllExtensions._` allows you to use numbers, `BigDecimal` objects etc. on left side of operands.

Defined operators are:
- `+` (addition)
- `-` (subtraction)
- `*` (multiplication)
- `/` (division)
- `^` (exponentiation)

In addition to these operators, following functions are also available after importing `func._`:

&nbsp;| Function
---|---
`abs(x)` | Absolute value of `x`
`ln(x)` | Natural (base-*e*) logarithm of `x`
`log(x)` | Base-10 logarithm of `x`
`log(b,v)` | Base-`b` logarithm of `v`
`exp(x)` | Exponential function (`e^x`)
`sin(x)` | Sine of `x` (in radians)
`cos(x)` | Cosine of `x` (in radians)
`tan(x)` | Tangent of `x` (in radians)
`cot(x)` | Cotangent of `x` (in radians)
`sec(x)` | Secant of `x` (in radians)

**Notes:**
- There is an additional `exp(x,i)` function defined, that uses Horner's method to evaluate value of `exp(x)` with
  limited iterations `i`. `exp(x,i)` is defined as:

  ![exp(x,i)](https://i.imgur.com/YXpZvLD.png)

  `exp(x)` function, without specified iterations, is an alias of `exp(x, 100)`, where `i = 100` was chosen arbitrarily
  (although it guarantees that Euler's number calculated as `e = exp(1)` is precise up to 33rd decimal digit).
- Exponentiation (`^` operator) is calculated according to following equation:
  
  ![x^y](https://i.imgur.com/lX3Tnn6.png)

  `exp(x)` is calculated with default iterations count. This implementation comes with a limitation: `x` must be a
  positive number.

### Derivatives

You can convert any function you have built into a derivative:

```scala
val x = Variable()
val f = 2 * x * x - 7
// f(x) = 2x² - 7

val df = f d x // "d" is a shortcut for derivative() method here
// df(x) = 4x

val result = df(x -> 3)
println(result) // 12
```

Currently, calculating derivatives does **not** simplify resulting function, so internally derivative of `2x² - 7`
is stored as `0⋅x + 2⋅1⋅x + 2⋅x⋅1 - 0` instead of simpler, but equivalent `4x`.

### Partial derivatives

Because `d` method requires a variable object, you can safely use this method to create partial derivatives:

```scala
val x = Variable()
val y = Variable()
val f = x * x * y * y + 3 * x * y - y
// f(x,y) = x²y² + 3xy - y

val fdx = f d x
// fdx(x, y) = 2xy² + 3y

val fdy = f d y
// fdy(x, y) = 2x²y + 3x - 1
```

### Higher derivatives

Because result of a `d()` method is also of type `Function`, there is no problem with calculating higher derivatives:

```scala
val x = Variable()

val f = 2 * x * x - 7
// f(x) = 2x² - 7

val df = f d x
// df(x) = 4x

val d2f = df d x
// d2f(x) = 4

val d3f = d2f d x
// d3f(x) = 0
```

## Constants

`eu.shooktea.eureka.Constants` object defines following constants:
* `Constants.E` - Euler's number, calculated with usage of `exp(1, i = 100)` (see description of `exp(x, i)` function
  in [functions section](#functions)). It gives precision up to 33rd decimal digit.
* `Constants.PI` - π, with precision up to 33rd decimal digit.