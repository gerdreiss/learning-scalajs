import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.dom.ext.*
import utest.*

import scala.scalajs.js

object TutorialTest extends TestSuite:

  // Initialize App
  TutorialApp.setupUI()

  def tests: Tests = Tests {
    test("HelloWorld") {
      assert(document.querySelectorAll("p").count(_.textContent == "Hello World") == 1)
    }

    test("ButtonClick") {
      def messageCount =
        document.querySelectorAll("p").count(_.textContent == "You clicked the button!")

      val button = document.querySelector("button").asInstanceOf[dom.html.Button]
      assert(button != null && button.textContent == "Click me!")
      assert(messageCount == 0)

      for c <- 1 to 5 do
        button.click()
        assert(messageCount == c)
    }
  }
