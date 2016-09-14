package helpers

import play.api.libs.json.{JsObject, Json}
import play.api.http._

import scala.language.postfixOps

/**
  * Created by shn on 2016/09/12.
  */
trait ResponseHelper {

  import ResponseHelper._

  def responseHTTP(hTTPResponse: HTTPResponse): JsObject = hTTPResponse toJson
}

object ResponseHelper {

  implicit class R(hTTPResponse: HTTPResponse) {
    def toJson: JsObject = Json obj("code" -> hTTPResponse.code, "message" -> hTTPResponse.message)
  }

}

sealed abstract class HTTPResponse(val code: Int, val message: String)

case object Success extends HTTPResponse(Status OK, "OK")

case object BadRequest extends HTTPResponse(Status BAD_REQUEST, "Bad Request")

case object Unauthorized extends HTTPResponse(Status UNAUTHORIZED, "Un Authorized")

case object Forbidden extends HTTPResponse(Status FORBIDDEN, "Forbidden")

case object NotFound extends HTTPResponse(Status NOT_FOUND, "Not Found")

case object InternalServerError extends HTTPResponse(Status INTERNAL_SERVER_ERROR, "Internal Server Error")
