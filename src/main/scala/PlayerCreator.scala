import scala.collection.mutable.ListBuffer
import scala.util.Random

case class PlayerCreator (firstNameList: List[String], lastNameList: List[String]) {

  val _firstNameList = firstNameList
  val _lastNameList = lastNameList

  def GetRandomName: (String, String) = {
    val lastNameIndex = Random.nextInt(_lastNameList.length)
    val firstNameIndex = Random.nextInt(_firstNameList.length)
    val firstName = _firstNameList.apply(firstNameIndex)
    val lastName = _lastNameList.apply(lastNameIndex)

    (firstName, lastName)
  }

  def GetRatings(postion: Int, rating: Int): List[Int] = {
    val baseList = List.fill(41)(375)

    postion match {
      case 1 =>
        baseList.zipWithIndex.map(x => {
          if (x._2 < 10) {
            //rating
            Random.nextInt(251) + 375
          }
          else {
            x._1
          }
        })

      case 2 =>
        baseList.zipWithIndex.map(x => {
          if (x._2 < 10) {
            x._1
          }
          else if (x._2 < 20 || x._2 == 24) {
            rating
          }
          else {
            x._1
          }
        })

      case _ =>
        baseList.map(x => Random.nextInt(251) + 375)
    }
  }

  def GetRandomPlayer(postion: Int, birthYear: Int, rating: Int): List[String] = {

    val aux = new ListBuffer[String]
    val name = GetRandomName
    aux.append(name._2)
    aux.append(name._1)
    aux.append(postion.toString)
    aux.append((Random.nextInt(5) + 72).toString)
    aux.append((Random.nextInt(75) + 250).toString)
    aux.append(birthYear.toString)
    aux.append((Random.nextInt(731) + 1).toString)

    val ratings = GetRatings(postion, rating)

    ratings.foreach(x => {
      aux.append(x.toString)
    })

    aux.append((Random.nextInt(13873) + 1).toString)
    aux.append(Random.nextInt(101).toString)
    aux.append(Random.nextInt(101).toString)
    aux.append(Random.nextInt(6).toString)

    aux.toList
  }

}
