package controllers

import com.google.inject.Inject
import helpers.{PdfHelper, ResponseHelper, Success}
import it.innove.play.pdf.PdfGenerator
import play.Configuration
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
  * Created by shn on 2016/09/11.
  */
class PdfController @Inject()(configuration: Configuration, pdfGenerator: PdfGenerator) extends Controller with ResponseHelper {

  val host = configuration getString PdfHelper.host
  val contentType = configuration getString PdfHelper.contentType
  val samplePdf = s"${configuration getString PdfHelper.directoryPdf}sample.pdf"

  def index = Action { implicit rs =>
    Ok(Json prettyPrint responseHTTP(Success))
  }

  def sample = Action { implicit rs =>
    Ok(pdfGenerator toBytes(views.html.pdf.sample render("sample", "hogehoge"), host)) as contentType
  }

  def sampleByInFile = Action { implicit rs =>
    import helpers.PdfHelper._
    Ok sendFile(content = samplePdf readCurrentPath, fileName = _ => "sample.pdf", inline = true)
  }
}
