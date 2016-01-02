import java.io.File

import com.github.tototoshi.csv.CSVWriter

object Main {

  def main(args: Array[String]): Unit = {

    def lastNameLocation = "C:\\Users\\MarkR\\Documents\\FOF\\Names\\CSV_Database_of_Last_Names.csv"
    def firstNameLocation = "C:\\Users\\MarkR\\Documents\\FOF\\Names\\CSV_Database_of_First_Names.csv"

    val output = new File("draft.csv")

    val lastNameList = FileHandler.LoadCsv(lastNameLocation)
    val firstNameList = FileHandler.LoadCsv(firstNameLocation)

    val writer = CSVWriter.open(output)
    val pc = PlayerCreator(firstNameList, lastNameList)
    val year = 1993
    val rating = 550

    1 to 17 foreach(i => {
      1 to 50 foreach(j => {
        writer.writeRow(pc.GetRandomPlayer(i, year, rating))
      })
    })

    writer.close()
  }
}
