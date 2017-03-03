package com.thoughtworks

import org.scalatest.{FreeSpec, Matchers}

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
final class TypeOfSpec extends FreeSpec with Matchers {

  """
    def t: TypeOf.`Ordering[Int].on { s: String => s.toInt }`.Ops = {
      val stringOrdering = Ordering[Int].on { s: String =>
        s.toInt
      }
      new stringOrdering.Ops("xx")
    }
  """ should compile

  """
    val xxx: TypeOf.`math.random.toString`.type = "another string"
  """ should compile

  "dependent functions" ignore {
    """
      trait Bar {
        def t: AnyRef
      }

      def foo(bar: Bar): TypeOf.`bar.t`.type = {
        bar.t
      }

      val s: String = foo(new Bar {
        def t: String = "x"
      })
    """ should compile
  }
}
