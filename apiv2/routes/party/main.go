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


func AddParty(c *gin.Context) {
	
	sess, err := db.Open(mongo.Adapter, settings)
	if err != nil {
		log.Fatalf("db.Open(): %q\n", err)
	}
	defer sess.Close()

	// Parametros del POST
	name := c.PostForm("name")
	cvr := c.PostForm("cover")
	cover, _ := strconv.ParseFloat(cvr, 64)
	fecha := c.PostForm("fecha")
	lat := c.PostForm("latitude")
	latitude, _ := strconv.ParseInt(lat, 10, 64)
	lng := c.PostForm("longitude")
	longitude, _ := strconv.ParseInt(lng, 10, 64)

	// Scheduler
	partyCollection, err := sess.Collection("parties")
	if err != nil {
		log.Fatalf("Could not use collection: %q\n", err)
	}
	
	// Nuestro nuevo registro 
	reg := new(models.Party)
	reg.Name = name
	reg.Cover = cover
	reg.Fecha = fecha
	reg.Location = models.Locations{Longitude: longitude, Latitude: latitude}

	partyCollection.Append(reg)
	c.JSON(200, reg)
}

func GetParties(c *gin.Context) {
	parties := make([]models.Party, 0)

	sess, err := db.Open(mongo.Adapter, settings)
	if err != nil {
		log.Fatalf("db.Open(): %q\n", err)
	}

	defer sess.Close()

	partyCollection, err := sess.Collection("parties")
	if err != nil {
		log.Fatalf("sess.Collection(): %q\n", err)
	}

	err = partyCollection.Find().All(&parties)
	if err != nil {
		log.Fatalf("Find(): %q\n", err)
	}

	c.JSON(200, parties)
}

func UpdateParty(c *gin.Context){
	c.Query
}