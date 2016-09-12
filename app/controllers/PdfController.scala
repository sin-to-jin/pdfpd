package controllers

import helpers.{ResponseHelper, Success}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
  * Created by shn on 2016/09/11.
  */
class PdfController extends Controller with ResponseHelper {

  def index = Action { implicit rs =>
    Ok(Json prettyPrint responseHTTP(Success))
  }

}
