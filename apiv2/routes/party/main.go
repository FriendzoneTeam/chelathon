package routes

import (
	"log"
	"strconv"
	"github.com/gin-gonic/gin"
	"chelathon/apiv2/models"
	"database/sql"
 	"github.com/mattn/go-sqlite3"
 	"encoding/json"
	"strconv"
)

func AddParty(c *gin.Context) {
  	
 	db, err := sql.Open("sqlite3", "./app.db")
 	if err != nil {
 		log.Fatal(err)
 	}
 	defer db.Close()
 
 	sqlStmt := `
 	CREATE TABLE IF NOT EXISTS parties (id integer not null primary key, name text, location text, cover text, fecha text);
 	`
 
 	_, err = db.Exec(sqlStmt)
  	if err != nil {
 		log.Printf("%q: %s\n", err, sqlStmt)
 		return
  	}
 
 	tx, err := db.Begin()
 	if err != nil {
 		log.Fatal(err)
 	}
 	stmt, err := tx.Prepare("insert into parties(name, location, cover, fecha) values(?, ?, ?, ?)")
 	if err != nil {
 		log.Fatal(err)
 	}
 	defer stmt.Close()
  
  	// Parametros del POST
  	name := c.PostForm("name")
  	latitude, _ := strconv.ParseInt(lat, 10, 64)
  	lng := c.PostForm("longitude")
  	longitude, _ := strconv.ParseInt(lng, 10, 64)
 
  	// Nuestro nuevo registro 
  	reg := new(models.Party)
  	reg.Name = name
  	reg.Cover = cover
  	reg.Fecha = fecha
 
 	b, err := json.Marshal(models.Locations{Longitude: longitude, Latitude: latitude})
 
 	_, err = stmt.Exec(name, string(b), cvr, fecha)
 	if err != nil {
 		log.Fatal(err)
 	}
     tx.Commit()
  

  	c.JSON(200, reg)
  }
  
  func GetParties(c *gin.Context) {
 	db, err := sql.Open("sqlite3", "./app.db")
  	if err != nil {
 		log.Fatal(err)
  	}
 	defer db.Close()
  
 	sqlStmt := `
 	CREATE TABLE IF NOT EXISTS parties (id integer not null primary key, name text, location text, cover text, fecha text);
 	`
 
 	_, err = db.Exec(sqlStmt)
  	if err != nil {
 		log.Printf("%q: %s\n", err, sqlStmt)
 		return
  	}
  
 	rows, err := db.Query("select id, name, location, cover, fecha from parties")
  	if err != nil {
 		log.Fatal(err)
 	}
 	defer rows.Close()
 
 	parties := make([]models.Party, 0)
 	for rows.Next() {
 		var id int
 		var name string
 		var location string
 		var cover string
 		var fecha string
 
 		rows.Scan(&id, &name, &location, &cover, &fecha)
 		var locations models.Locations
 		err := json.Unmarshal([]byte(location), &locations)
 		if err != nil {
 	        panic(err)
 	    }
 		var reg models.Party
 		reg.Id = id
 		reg.Name = name
 		reg.Location = locations
 	    cvr, _ := strconv.ParseFloat(cover, 64)
 		reg.Cover = cvr
 		reg.Fecha = fecha
 		parties = append(parties, reg)
  	}
  
  	c.JSON(200, parties)
 }

func UpdateParty(c *gin.Context){

	idpS := c.Params.ByName("id")
	idp := strconv.Atoi(idpS)


	name := c.PostForm("name")
	cvr := c.PostForm("cover")
	cover, _ := strconv.ParseFloat(cvr, 64)
	fecha := c.PostForm("fecha")
	lat := c.PostForm("latitude")
	latitude, _ := strconv.ParseInt(lat, 10, 64)
	lng := c.PostForm("longitude")
	longitude, _ := strconv.ParseInt(lng, 10, 64)

}
