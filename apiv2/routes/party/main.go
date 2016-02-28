package routes

import (
	"log"
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

	// Scheduler
	partyCollection, err := sess.Collection("parties")
	if err != nil {
		log.Fatalf("Could not use collection: %q\n", err)
	}
	
	// Nuestro nuevo registro 
	reg := new(models.Party)
	reg.Name = name
	reg.Fecha = "new Date()"
	reg.Location = models.Locations{}

	partyCollection.Append(reg)
	c.JSON(200, reg)
}

func GetParties(c *gin.Context) {
	Parties := make([]models.Party, 0)

	c.JSON(200, Parties)
}