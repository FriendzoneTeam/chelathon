package main

import (
	"github.com/gin-gonic/gin"
	Party "chelathon/apiv2/routes/party"
	Venue "chelathon/apiv2/routes/venue"
	Person "chelathon/apiv2/routes/person"
	Pool "chelathon/apiv2/routes/pool"
)

func main() {
	r := gin.Default()

	r.GET("/parties", Party.GetParties)
    r.POST("/parties", Party.AddParty)

    r.PUT("/parties", nil )
	r.POST("/parties/:idp/panic", nil)
	r.POST("/parties/:idp/pool", nil)
	r.GET("/parties/:idp/pool", nil)

    r.POST("/venues", Venue.AddVenue)
    r.GET("/venues", Venue.GetVenues)

    // Persons
    r.POST("/persons", Person.AddPerson)
    r.GET("/persons", Person.GetPersons)

    // Pool
    r.POST("/pools", Pool.AddPool)
    r.GET("/pools", Pool.GetPools)
    r.Run()
}
