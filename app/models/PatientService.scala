package models

import repositories._
import javax.inject.Inject
import play.api.libs.json._



case class Patient(idPatient:String,firstName: String,lastName : String,introduced: String)



