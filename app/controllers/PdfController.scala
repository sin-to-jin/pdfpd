package controllers

import com.google.inject.Inject
import helpers.{ResponseHelper, Success}
import it.innove.play.pdf.PdfGenerator
import play.Configuration
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import helpers.PdfHelper._

/**
  * Created by shn on 2016/09/11.
  */
class PdfController @Inject()(configuration: Configuration, pdfGenerator: PdfGenerator) extends Controller with ResponseHelper {
  {
    import collection.JavaConversions._
    pdfGenerator.loadLocalFonts(List("fonts/ipaexg.ttf", "fonts/ipaexm.ttf").toList)
  }

  def index = Action { implicit rs =>
    Ok(Json prettyPrint responseHTTP(Success))
  }

  def sample = Action { implicit rs =>
    Ok(pdfGenerator toBytes(views.html.pdf.sample render("sample", "hogehoge"), configuration host)).as(configuration contentType)
  }

  def sampleByInFile = Action { implicit rs =>
    Ok sendFile(content = configuration.samplePdf readCurrentPath, fileName = _ => "sample.pdf", inline = true)
  }
}
