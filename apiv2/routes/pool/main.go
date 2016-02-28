package routes

import (
	"log"
	"strconv"
	"github.com/gin-gonic/gin"
	"chelathon/apiv2/models"
	"database/sql"
	_ "github.com/mattn/go-sqlite3"
)

func AddPool(c *gin.Context) {
	

	db, err := sql.Open("sqlite3", "./app.db")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	sqlStmt := `
	CREATE TABLE IF NOT EXISTS pools (id integer not null primary key, id_user integer, cuota numeric, id_party integer);
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
	stmt, err := tx.Prepare("insert into pools(id_user, cuota, id_party) values(?, ?, ?)")
	if err != nil {
		log.Fatal(err)
	}
	defer stmt.Close()

	// Parametros del POST
	idUser := c.PostForm("id_user")
	id_user, _ := strconv.ParseInt(idUser, 10, 64)
	cta := c.PostForm("cuota")
	cuota, _ := strconv.ParseFloat(cta, 64)
	idParty := c.PostForm("id_user")
	id_party, _ := strconv.ParseInt(idParty, 10, 64)
	
	// Nuestro nuevo registro 
	reg := new(models.Pool)
	reg.Id_user = id_user
	reg.Cuota = cuota
	reg.Id_party = id_party

	_, err = stmt.Exec(id_user, cuota, id_party)
	if err != nil {
		log.Fatal(err)
	}
    tx.Commit()

	c.JSON(200, reg)
}

func GetPools(c *gin.Context) {
	db, err := sql.Open("sqlite3", "./app.db")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	sqlStmt := `
	CREATE TABLE IF NOT EXISTS pools (id integer not null primary key, id_user integer, cuota numeric, id_party integer);
	`

	_, err = db.Exec(sqlStmt)
	if err != nil {
		log.Printf("%q: %s\n", err, sqlStmt)
		return
	}

	rows, err := db.Query("select id, id_user, cuota, id_party from pools")
	if err != nil {
		log.Fatal(err)
	}
	defer rows.Close()

	pools := make([]models.Pool, 0)
	for rows.Next() {
		var id int
		var id_user int64
		var cuota float64
		var id_party int64

		rows.Scan(&id, &id_user, &cuota, &id_party)
		var reg models.Pool
		reg.Id = id
		reg.Id_user = id_user
		reg.Cuota = cuota
		reg.Id_party = id_party
		pools = append(pools, reg)
	}

	c.JSON(200, pools)
}