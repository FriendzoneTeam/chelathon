package routes

import (
	"log"
	"github.com/gin-gonic/gin"
	"chelathon/apiv2/models"
	"database/sql"
	_ "github.com/mattn/go-sqlite3"
	"encoding/json"
	"strconv"
)

func AddVenue(c *gin.Context) {
	db, err := sql.Open("sqlite3", "./app.db")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	sqlStmt := `
	CREATE TABLE IF NOT EXISTS venues (id integer not null primary key, name text, location text, dir1 text, dir2 text, id_owner integer, id_party integer);
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
	stmt, err := tx.Prepare("insert into venues(name, location, dir1, dir2, id_owner, id_party) values(?, ?, ?, ?, ? ,?)")
	if err != nil {
		log.Fatal(err)
	}
	defer stmt.Close()

	// Parametros del POST
	name := c.PostForm("name")
	dir1 := c.PostForm("dir1")
	dir2 := c.PostForm("dir2")
	id_o := c.PostForm("id_owner")
	id_owner, _ := strconv.ParseInt(id_o,10, 64)
	id_p := c.PostForm("id_party")
	id_party, _ := strconv.ParseInt(id_p,10, 64)
	
	// Nuestro nuevo registro 
	reg := new(models.Venue)
	reg.Name = name
	var locs models.Locations
	b, _ := json.Marshal(locs)
	reg.Location = locs
	reg.Dir1 = dir1
	reg.Dir2 = dir2
	reg.Id_owner = id_owner
	reg.Id_party = id_party

	_, err = stmt.Exec(name, string(b), dir1, dir2, id_owner, id_party)
	if err != nil {
		log.Fatal(err)
	}
    tx.Commit()
	c.JSON(200, gin.H{"message": "Venue created"})
}

func GetVenues(c *gin.Context) {
	db, err := sql.Open("sqlite3", "./app.db")
  	if err != nil {
 		log.Fatal(err)
  	}
 	defer db.Close()

 	sqlStmt := `
	CREATE TABLE IF NOT EXISTS venues (id integer not null primary key, name text, location text, dir1 text, dir2 text, id_owner integer, id_party integer);
	`
 
 	_, err = db.Exec(sqlStmt)
  	if err != nil {
 		log.Printf("%q: %s\n", err, sqlStmt)
 		return
  	}
  
 	rows, err := db.Query("select id, name, location, location, dir1, dir2, id_owner, id_party from parties")
  	if err != nil {
 		log.Fatal(err)
 	}
 	defer rows.Close()

	venues := make([]models.Venue, 0)
	for rows.Next() {
 		var id int
 		var name string
 		var location string
 		var dir1 string
 		var dir2 string
 		var id_owner int
 		var id_party int
 
 		rows.Scan(&id, &name, &location, &dir1, &dir2, &id_owner, &id_party)
 		var locations models.Locations
 		err := json.Unmarshal([]byte(location), &locations)
 		if err != nil {
 	        panic(err)
 	    }
 		var reg models.Venue
 		reg.Id = id
 		reg.Name = name
 		reg.Location = locations
 		reg.Dir1 = dir1
 		reg.Dir2 = dir2
 		reg.Id_owner = int64(id_owner)
 		reg.Id_party = int64(id_party)
 		venues = append(venues, reg)
  	}

	c.JSON(200, venues)
}