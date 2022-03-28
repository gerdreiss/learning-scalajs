import org.scalajs.dom
import org.scalajs.dom.document


object TutorialApp:
  def main(args: Array[String]): Unit =
    document.addEventListener(
      "DOMContentLoaded",
      (e: dom.Event) => setupUI()
    )

  def setupUI(): Unit =
    val button = document.createElement("button")
    button.textContent = "Click me!"
    button.addEventListener(
      "click",
      (e: dom.MouseEvent) => addClickedMessage()
    )

    val parNode = document.createElement("p")
    parNode.textContent = "Hello World"

    document.body.appendChild(button)
    document.body.appendChild(parNode)

  // only necessary if the button is created directly in HTML:
  // import scala.scalajs.js.annotation.JSExportTopLevel
  // @JSExportTopLevel("addClickedMessage")
  def addClickedMessage(): Unit =
    val parNode = document.createElement("p")
    parNode.textContent = "You clicked the button!"
    document.body.appendChild(parNode)
