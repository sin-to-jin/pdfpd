package helpers

import java.io.File
import play.Configuration

/**
  * Created by shn on 2016/09/12.
  */
case class PdfHelper()

object PdfHelper {

  implicit class C(configuration: Configuration) {
    implicit val HTTPHostAndPort = "pdf.http.local.host"
    implicit val HTTPContentType = "pdf.http.content.type"
    implicit val HTTPDirectoryPdf = "pdf.https.directory.path"

    def host: String = configuration getString HTTPHostAndPort

    def contentType: String = configuration getString HTTPContentType

    def samplePdf: String = s"${configuration getString HTTPDirectoryPdf}sample.pdf"
  }

  implicit class P(path: String) {
    def currentPath: String = s"${new File(".").getAbsoluteFile getParent}/$path"

    def readCurrentPath: File = new File(currentPath)
  }

}