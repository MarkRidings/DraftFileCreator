import scala.io.Source

object FileHandler {

  def LoadCsv(fileName: String, hasHeader: Boolean = false): List[String] = {

    val file = Source.fromFile(fileName).getLines().toList

    file.map(x => x.split(',').head)
  }


}
