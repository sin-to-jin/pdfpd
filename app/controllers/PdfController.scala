package controllers

import com.google.inject.Inject
import helpers.{ResponseHelper, Success}
import it.innove.play.pdf.PdfGenerator
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
  * Created by shn on 2016/09/11.
  */
class PdfController @Inject()(pdfGenerator: PdfGenerator) extends Controller with ResponseHelper {

  val host = "localhost:9000"
  val contentType = "application/pdf"

  def index = Action { implicit rs =>
    Ok(Json prettyPrint responseHTTP(Success))
  }

  def sample = Action { implicit rs =>
    Ok(pdfGenerator.toBytes(views.html.pdf.sample.render("sample", "hogehoge"), host)).as(contentType)
  }

}
