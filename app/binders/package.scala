package binders

import play.api.mvc.PathBindable
import models.Article

object `package` {

  implicit def articlePathBindable(implicit longBinder: PathBindable[Long]) = new PathBindable[Article] {

    def bind(key: String, value: String): Either[String, Article] =
      for {
        id <- longBinder.bind(key, value).right
        article <- Article.findById(id).toRight("Article not found").right
      } yield article

    def unbind(key: String, article: Article): String =
      longBinder.unbind(key, article.id)

  }

}