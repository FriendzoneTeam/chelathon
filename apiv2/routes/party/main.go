package routes

import (
	"log"
	"github.com/gin-gonic/gin"
	"chelathon/apiv2/models"
	"upper.io/db.v2"
	"upper.io/db.v2/mongo"
)

func AddParty(c *gin.Context) {
	//Setting de la coneccion a mongo
	var settings = mongo.ConnectionURL{
		Address:  db.Host("ds049945.mongolab.com:49945"), // MongoDB hostname.
		Database: "socialgopher",                         // Database name.
		User:     "friendzonedb",                         // Optional user name.
		Password: "friendzonedb",                         // Optional user password.
	}
	
	sess, err := db.Open(mongo.Adapter, settings)
	if err != nil {
		log.Fatalf("db.Open(): %q\n", err)
	}
	defer sess.Close()

	// Scheduler
	lCollection, err := sess.Collections()
	if len(lCollection) != 0 {
		log.Println("Existe la collection")
		partyCollection, err := sess.Collection("parties")
		if err != nil {
			log.Fatalf("Could not use collection: %q\n", err)
		}
		var parties []models.Party
		// Parametros del POST
		name := c.PostForm("name")
		// Nuestro nuevo registro 
		reg := new(models.Party)
		reg.Name = name
		reg.Fecha = "new Date()"
		reg.Location = models.Locations{}

		var res db.Result
		partyCollection.Append(reg)
		c.JSON(200, reg)
	} else {
		log.Println("No existe la collection")
	}

	
	c.JSON(200, name)
}

func GetParties(c *gin.Context) {
	Parties := make([]models.Party, 0)

	c.JSON(200, Parties)
}