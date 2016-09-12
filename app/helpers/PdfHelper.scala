package helpers

import java.io.File

/**
  * Created by shn on 2016/09/12.
  */
case class PdfHelper()

object PdfHelper {

  val host = "pdf.http.local.host"
  val contentType = "pdf.http.content.type"
  val directoryPdf = "pdf.https.directory.path"

  implicit class P(path: String) {
    def currentPath: String = s"${new File(".").getAbsoluteFile getParent}/$path"

    def readCurrentPath: File = new File(currentPath)
  }

}