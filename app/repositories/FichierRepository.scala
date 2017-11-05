package repositories


import models._
import play.api.libs.json._
import java.util.concurrent
import java.util.concurrent.ConcurrentHashMap


trait FichierRepositoryComponent {
    val fichierRepository:  FichierRepository

    trait FichierRepository {
        def getAllFichier () : List[Fichier]      
        def tryFindById(idPatient: String): Option[Fichier]
  
    }
}

trait FichierRepositoryComponentImpl extends FichierRepositoryComponent {
    override val fichierRepository = new FichierRepositoryImpl
class FichierRepositoryImpl extends FichierRepository {   
val fichiers = new ConcurrentHashMap[Int,Fichier]
val patients = new ConcurrentHashMap[String,Patient]

// test ajout des fichier 

fichiers.put(0,Fichier("inr_simple",Correspondent("COUCOU","ide","Erlich","Bachman","0633471153"),Patient("92010201867", "Richard","Hendricks","01-06-1986"),ResultPation("B71012P6823-PUIMA-/INRW", 1507884006000L, "inr_simple","Pvt 12/10/2017 à 10:00:00\nDossier 525648-P-6823\nINR: 2.6 \n Laboratoire Silicon Valley")))
fichiers.put(1,Fichier("inr_simple",Correspondent("COUCOU","ide","Erlich","Bachman","0633471153"),Patient("2", "Richard","Hendricks","01-06-1986"),ResultPation("B71012P6823-PUIMA-/INRW", 1507884006000L, "inr_simple","Pvt 12/10/2017 à 10:00:00\nDossier 525648-P-6823\nINR: 2.6 \n Laboratoire Silicon Valley")))
fichiers.put(2,Fichier("inr_simple",Correspondent("COUCOU","ide","Erlich","Bachman","0633471153"),Patient("3", "Richard","Hendricks","01-06-1986"),ResultPation("B71012P6823-PUIMA-/INRW", 1507884006000L, "inr_simple","Pvt 12/10/2017 à 10:00:00\nDossier 525648-P-6823\nINR: 2.6 \n Laboratoire Silicon Valley")))
fichiers.put(3,Fichier("inr_simple",Correspondent("COUCOU","ide","Erlich","Bachman","0633471153"),Patient("4", "Richard","Hendricks","01-06-1986"),ResultPation("B71012P6823-PUIMA-/INRW", 1507884006000L, "inr_simple","Pvt 12/10/2017 à 10:00:00\nDossier 525648-P-6823\nINR: 2.6 \n Laboratoire Silicon Valley")))


override  def getAllFichier () :  List[Fichier] = {
var all = List[Fichier]()
for (j<-0 to (fichiers.size()-1)){
all = fichiers.get(j) :: all
}
return all
}

override def tryFindById(idpatient: String): Option[Fichier] = {
for (i<-0 to (fichiers.size()-1)){
  patients.put(fichiers.get(i).patient.idPatient,fichiers.get(i).patient)

}
val patient = patients.get(idpatient)
for (j<-0 to (fichiers.size()-1)){
    if ((fichiers.get(j).patient).equals(patient)){ 
  return Option(fichiers.get(j))    
    }
}
return null
}
}


}
    

