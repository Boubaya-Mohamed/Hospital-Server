package controllers


import models._
import play.api.mvc._
import play.api.libs.json._
import models.FichierServiceComponent
import play.api.libs.functional.syntax._


trait FichierController extends Controller {
 self: FichierServiceComponent =>

	implicit val PatientWrites : Writes[Patient] =(
	(JsPath \ "idPatient").write[String] and
  (JsPath \ "firstName").write[String] and 
   (JsPath \ "lastName").write[String] and 
   (JsPath \ "introduced").write[String] 
)(unlift(Patient.unapply))

	implicit val CorrespondentWrites : Writes[Correspondent]  = (
	(JsPath \ "idCorrespondent").write[String] and
  (JsPath \ "profil").write[String] and 
   (JsPath \ "firstName").write[String] and 
   (JsPath \ "lastName").write[String] and 
   (JsPath \ "mobile:").write[String] 
)(unlift(Correspondent.unapply))

	implicit val ResultPationWrites : Writes[ResultPation]  = (
	(JsPath \ "idResult").write[String] and
  (JsPath \ "dateOfResult").write[Long] and 
   (JsPath \ "msg_type").write[String] and 
   (JsPath \ "msg_raw").write[String] 
   
)(unlift(ResultPation.unapply))

implicit val FichierWrites : Writes[Fichier]  = (
	(JsPath \ "msg_type").write[String] and
  (JsPath \ "correspondent").write[Correspondent] and 
   (JsPath \ "patient").write[Patient] and 
   (JsPath \ "result").write[ResultPation] 
   
)(unlift(Fichier.unapply))


def listFichier = Action {

Ok(Json.toJson(fichierService.getAllFichier()))
}

 def list(page:Int) = Action {
    val pageLength = 3
    val fichiers = fichierService.getAllFichier()
    Ok(Json.toJson(fichiers.slice(pageLength*(page-1),pageLength*page)))
  }

 def findPatientSById(idPatient: String) = Action {
        val fichier = fichierService.tryFindById(idPatient)
        if (fichier.isDefined) {
            Ok(Json.toJson(fichier))
        } else {
            NotFound
            }
        }

 def index = Action { 
Ok("Hello Word Coppyright mohamed Boubaya Nov-2017 ")
 }

}
  