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

func AddPool(c *gin.Context) {
	// DB Conf
	sess, err := db.Open(mongo.Adapter, settings)
	if err != nil {
		log.Fatalf("db.Open(): %q\n", err)
	}
	defer sess.Close()

	// Parametros del POST
	idUser := c.PostForm("id_user")
	id_user, _ := strconv.ParseInt(lat, 10, 64)

	cvr := c.PostForm("cover")
	cover, _ := strconv.ParseFloat(cvr, 64)

	c.JSON(200, interface{})
}

func GetPools (c *gin.Context) {
	// DB Conf
	sess, err := db.Open(mongo.Adapter, settings)
	if err != nil {
		log.Fatalf("db.Open(): %q\n", err)
	}
	defer sess.Close()

	// Consulta 
	pools := make([]models.Pool, 0)
	poolCollection, err := sess.Collection("pools")
	if err != nil {
		log.Fatalf("sess.Collection(): %q\n", err)
	}

	err = poolCollection.Find().All(&pools)
	if err != nil {
		log.Fatalf("Find(): %q\n", err)
	}

	c.JSON(200, pools)
}