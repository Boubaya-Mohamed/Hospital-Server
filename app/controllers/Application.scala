package controllers


import models._
import repositories._
import play.api.mvc._
import play.api.libs.json._
import models.FichierServiceComponentImpl
import repositories.FichierRepositoryComponentImpl



import play.api.libs.functional.syntax._

class Application extends FichierController
                   with FichierServiceComponentImpl
                   with  FichierRepositoryComponentImpl{
                  

                   }





