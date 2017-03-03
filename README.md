# TypeOf.scala
Create types from expressions

``` scala
type TypeOfToString = TypeOf.`math.random.toString`.type
```

``` scala
val typeOfToString: TypeOf.`math.random.toString`.type = "another string"
```

``` scala
def ops: TypeOf.`Ordering[Int].on { s: String => s.toInt }`.Ops = {
  val ordering = Ordering[Int].on { s: String => s.toInt }
  new ordering.Ops("xx")
} 
```
