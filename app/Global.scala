
import play.api.GlobalSettings
import play.api.mvc.RequestHeader
import play.api.mvc.Results._

object Global extends GlobalSettings {

  override def onBadRequest(request: RequestHeader, error: String) = error match {
    case "Article not found" => Redirect(controllers.routes.Articles.list)
    case _ => super.onBadRequest(request, error)
  }

}