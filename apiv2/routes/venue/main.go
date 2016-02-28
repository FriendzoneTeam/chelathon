package routes

import (
	"log"
	"strconv"
	"github.com/gin-gonic/gin"
	"chelathon/apiv2/models"
	"upper.io/db.v2"
	"upper.io/db.v2/mongo"
)

//Setting de la coneccion a mongo
	var settings = mongo.ConnectionURL {
		Address:  db.Host("ds049945.mongolab.com:49945"), // MongoDB hostname.
		Database: "socialgopher",                         // Database name.
		User:     "friendzonedb",                         // Optional user name.
		Password: "friendzonedb",                         // Optional user password.
	}

func AddVenue(c *gin.Context) {
	sess, err := db.Open(mongo.Adapter, settings)
	if err != nil {
		log.Fatalf("db.Open(): %q\n", err)
	}
	defer sess.Close()

	// Parametros del POST
	name := c.PostForm("name")
	dir1 := c.PostForm("dir1")
	dir2 := c.PostForm("dir2")
	id_o := c.PostForm("id_owner")
	id_owner, _ := strconv.ParseInt(id_o,10, 64)
	id_p := c.PostForm("id_party")
	id_party, _ := strconv.ParseInt(id_p,10, 64)

	// Scheduler
	venueCollection, err := sess.Collection("venues")
	if err != nil {
		log.Fatalf("Could not use collection: %q\n", err)
	}
	
	// Nuestro nuevo registro 
	reg := new(models.Venue)
	reg.Name = name
	reg.Location = models.Locations{}
	reg.Dir1 = dir1
	reg.Dir2 = dir2
	reg.Id_owner = id_owner
	reg.Id_party = id_party

	venueCollection.Append(reg)
	c.JSON(200, reg)
}

func GetVenues(c *gin.Context) {
	Parties := make([]models.Venue, 0)

	c.JSON(200, Parties)
}