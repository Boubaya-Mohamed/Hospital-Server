package models


import play.api.libs.json._
import javax.inject.Inject


case class ResultPation(

                   idResult:String,
                   dateOfResult: Long,
                   msg_type: String,
                   msg_raw: String 

                 )



