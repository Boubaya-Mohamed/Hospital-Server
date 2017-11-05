package models


import repositories._
import play.api.libs.json._
import javax.inject.Inject


import java.util.Date
case class Fichier
(
        msg_type:String,
        correspondent : Correspondent,
        patient: Patient,
        result : ResultPation
        )



trait FichierServiceComponent {
    
    val fichierService: FichierService

    trait FichierService {
       
        def tryFindById(idPatient: String): Option[Fichier]
        def getAllFichier() : List[Fichier] 

    }

}

 trait FichierServiceComponentImpl extends FichierServiceComponent {
    
self: FichierRepositoryComponent =>
    override val fichierService = new FichierServiceImpl
    
    class FichierServiceImpl extends FichierService {
    	 override def tryFindById(idPatient: String): Option[Fichier] = {
            fichierRepository.tryFindById(idPatient)
        }
        override def getAllFichier() : List[Fichier]  = {
            fichierRepository.getAllFichier()
        }

    }
}