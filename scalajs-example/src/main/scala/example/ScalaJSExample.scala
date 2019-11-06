package example

import org.scalajs.dom
import org.scalajs.dom.html
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import scala.util.Random

case class Point(x: Int, y: Int) {
  def +(p: Point) = Point(x + p.x, y + p.y)
  def /(d: Int) = Point(x / d, y / d)
}

@JSExportTopLevel(name = "example")
object ScalaJSExample {

  @JSExport
  def main(canvas: html.Canvas): Unit = {
    val ctx = canvas
      .getContext("2d")
      .asInstanceOf[dom.CanvasRenderingContext2D]

    var count = 0
    var p = Point(0, 0)
    val corners = List(Point(512, 512), Point(0, 512), Point(255, 0))

    def clear() = {
      ctx.fillStyle = "black"
      ctx.fillRect(0, 0, 512, 512)
    }

    def run = for (i <- 0 until 10) {
      if (count % 5000 == 0) clear()
      count += 1
      p = (p + corners(Random.nextInt(3))) / 2

      val height = 1024.0 / (512 + p.y)
      val r = (p.x * height).toInt
      val g = ((512 - p.x) * height).toInt
      val b = p.y

      ctx.fillStyle = s"rgb($g, $r, $b)"
      ctx.fillRect(p.x, p.y, 1, 1)
    }

    dom.window.setInterval(() => run, 50)
  }
}
