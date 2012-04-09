package models

case class Article(id: Long, name: String, price: Double)

object Article {
  private val articles = List(
      Article(1, "Something", 42.0),
      Article(2, "Nothing", 0.0),
      Article(3, "Another", 10.0)
  )

  def findAll: List[Article] = articles

  def findById(id: Long): Option[Article] = articles.find(_.id == id)
}