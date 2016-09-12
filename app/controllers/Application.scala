package controllers

import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
  * Created by shn on 2016/09/11.
  */
class Application extends Controller {

  def index = Action { implicit rs =>
    Ok(Json.prettyPrint(Json obj("code" -> "200", "message" -> "OK", "errors" -> Json.obj("field" -> "", "message" -> ""))))
  }

}
