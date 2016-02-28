package models

import "chelathon/models/Locations"

struct Party {
	Id int
	Name string
	Location Locations
}