package controllers

import scala.concurrent.duration._
import scala.concurrent.Await
import org.junit._
import org.junit.Assert._
import org.mockito.Mockito._
import play.api.test._
import play.api.test.Helpers._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import models.FichierService._

class FichierControllerTest {
    
    private val fichierController = new FichierController with FichierServiceComponentMock {}
  
trait  FichierServiceComponentMock extends  FichierServiceComponent  {
    
    override val fichierService = mock(classOf[FichierService])
    }
}
