### Pour démarrer l'application: 
#### sbt run 

et aprés :
```
 http://localhost:9000
```
Pour utiliser l'API REST: on utlise postman ou commande curl

or dans cette application il s'agit que des Method "GET" donc vous pouvez utiliser n'importe quel browser 

##  Lecture de mes résultats (Patients)
```
GET     http://localhost:9000/listfichier/92010201867
```
À l'aide d'ID patient, vous pourrez récupérer tous les résultats de patient d'Id 92010201867 . 

## Lecture des résultats correspondants
```
GET     http://localhost:9000/listfichier
```
vous pouvez récupérer tous les résultats des patients .

## Pagination

```
GET    http://localhost:9000/list/1

```
Vous pouvez récupérer tous les résultats de 3 primaires patients et si vous changerez 1 par 2 vous prouverez récupérer tous les résultats de 4e, 5e, 6e patient.

##  Test unitaire

je  n'ai pas eu le temps j'ai été très occupé par maïs étude (c'est le period des examens)

## Question

N’hésitez pas à me contacter pour toute information que vous jugerez nécessaire. 

Email :  mohamedboubaya1@gmail.com
