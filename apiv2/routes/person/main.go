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
