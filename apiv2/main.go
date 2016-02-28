package main

import (
	"github.com/gin-gonic/gin"
	Party "chelathon/apiv2/routes/party"
	Venue "chelathon/apiv2/routes/venue"
)

func main() {
	r := gin.Default()
	
    r.POST("/parties", Party.AddParty)
    r.GET("/parties", Party.GetParties)
    r.POST("/venues", Venue.AddVenue)
    r.GET("/venues", Venue.GetVenues)
    
    r.Run()
}