package com.thoughtworks
import scala.language.dynamics
import scala.language.experimental.macros
import scala.reflect.macros.whitebox

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
object TypeOf extends Dynamic {

  def selectDynamic(code: String): Any = macro Macros.selectDynamic

  @macrocompat.bundle
  class Macros(val c: whitebox.Context) {
    import c.universe.{Try => _, _}
    import internal._, decorators._

    def selectDynamic(code: Tree): Tree = {

      val q"${codeString: String}" = code
      val tpe = c.typecheck(c.parse(codeString)).tpe

      // Bail for primitives because the resulting trees with type set to Unit
      // will crash the compiler
      if(tpe.typeSymbol.asClass.isPrimitive)
        c.abort(c.enclosingPosition, s"Primitive type $tpe may not be used in this context")


      // We can't yield a useful value here, so return Unit instead which is at least guaranteed
      // to result in a runtime exception if the value is used in term position.
      Literal(Constant(())).setType(tpe)
    }
  }

}
