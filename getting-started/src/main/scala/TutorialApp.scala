import org.scalajs.dom
import org.scalajs.dom.{ document, Element, MouseEvent, Node }

object TutorialApp:
  def main(args: Array[String]): Unit =
    dom.document.addEventListener("DOMContentLoaded", _ => setupUI())

  def setupUI(): Unit =
    val button = document.createElement("button")
    button.textContent = "Click me!"
    button.addEventListener(
      "click",
      (e: dom.MouseEvent) =>
        addClickedMessage()
    )
    document.body.appendChild(button)

    appendPar(document.body, "Hello World")

  // only necessary if the button is created directly in HTML:
  // import scala.scalajs.js.annotation.JSExportTopLevel
  // @JSExportTopLevel("addClickedMessage")
  def addClickedMessage(): Unit =
    appendPar(document.body, "You clicked the button!")

  def appendPar(targetNode: dom.Node, text: String): Unit =
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
