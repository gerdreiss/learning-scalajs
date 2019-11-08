import org.scalajs.dom
import dom.html
import scalajs.js.annotation.JSExport
import scalatags.JsDom.all._
import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel(name = "helloworld0")
object HelloWorld0 extends {

  @JSExport
  def main(target: html.Div) = {
    val (animalA, animalB) = ("fox", "dog")
    target.appendChild(
      div(
        h1("Hello World!"),
        p(
          "The quick brown ",
          b(animalA),
          " jumps over the lazy ",
          i(animalB),
          "."
        )
      ).render
    )

    val output = span.render
    val box = input(`type` := "text", placeholder := "Type here!").render

    box.onkeyup = (e: dom.Event) => {
      output.textContent = box.value.toUpperCase
    }

    target.appendChild(
      div(
        h1("Capital Box!"),
        p("Type here and have it capitalized!"),
        div(box),
        div(output)
      ).render
    )

  }
}
