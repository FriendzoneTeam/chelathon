package main

import (
	"github.com/gin-gonic/gin"
	Party "chelathon/apiv2/routes/party"
)

func main() {
	r := gin.Default()
	
    r.GET("/parties", Party.AddParty)
    r.Run()
}