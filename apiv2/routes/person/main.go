package routes

import (
	"log"
	"github.com/gin-gonic/gin"
	"chelathon/apiv2/models"
	"database/sql"
	_ "github.com/mattn/go-sqlite3"
)

func AddPerson(c *gin.Context) {
	
	db, err := sql.Open("sqlite3", "./app.db")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	sqlStmt := `
	CREATE TABLE IF NOT EXISTS persons (id integer not null primary key, name text, foto text);
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
	stmt, err := tx.Prepare("insert into persons(name, foto) values(?, ?)")
	if err != nil {
		log.Fatal(err)
	}
	defer stmt.Close()

	// Parametros del POST
	nombre := c.PostForm("nombre")
	foto := c.PostForm("foto")

	// Add Person to MongoDB
	var reg models.Person
	reg.Nombre = nombre
	reg.Foto = foto

	_, err = stmt.Exec(nombre, foto)
	if err != nil {
		log.Fatal(err)
	}
    tx.Commit()
	c.JSON(200, gin.H{"message": "Person created"})
}

func GetPersons (c *gin.Context) {

	db, err := sql.Open("sqlite3", "./app.db")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	sqlStmt := `
	CREATE TABLE IF NOT EXISTS persons (id integer not null primary key, name text, foto text);
	`

	_, err = db.Exec(sqlStmt)
	if err != nil {
		log.Printf("%q: %s\n", err, sqlStmt)
		return
	}

	rows, err := db.Query("select id, name, foto from persons")
	if err != nil {
		log.Fatal(err)
	}
	defer rows.Close()

	persons := make([]models.Person, 0)
	for rows.Next() {
		var id int
		var name string
		var foto string
		rows.Scan(&id, &name, &foto)
		var reg models.Person
		reg.Id = id
		reg.Nombre = name
		reg.Foto = foto
		persons = append(persons, reg)
	}

	c.JSON(200, persons)
}