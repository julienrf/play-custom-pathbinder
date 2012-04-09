package controllers

import play.api._
import play.api.mvc._

import models.Article

object Articles extends Controller {

  def list = Action {
    Ok(views.html.index(Article.findAll))
  }

  def show(article: Article) = Action {
    Ok(views.html.article(article))
  }

}