package models

import (
	"gopkg.in/mgo.v2/bson"
)

type Locations struct{
	Longitude int64 `json:"longitude" bson:"longitude"`
	Latitude int64 `json:"latitude" bson:"latitude"`
}

type Party struct{
	Id bson.ObjectId `json:"id" bson:"_id"`
	Name string `json:"name" bson:"name"`
	Location Locations `json:"locations" bson:"locations"`
	Cover float64 `json:"cover" bson:"cover"`
	Fecha string `json:"fecha" bson:"fecha"`
}

func (party *Party) SetID(id bson.ObjectId) error {
	party.Id = id
	return nil
}

type Venue struct {
	Name string
	Location Locations
	Dir1 string
	Dir2 string
	id_owner int
	id_party int
}

type Person struct {
	Id int
	Nombre string
	Foto string
}

type Pool struct {
	Id_user int
	Cuota	float64
	id_party int
}