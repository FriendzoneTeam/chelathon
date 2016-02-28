package models

type Locations struct{
	Longitude int
	Latitude int
}

type Party struct{
	Id int
	Name string
	Location Locations
}