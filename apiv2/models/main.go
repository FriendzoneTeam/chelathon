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
	Id_owner int64
	Id_party int64
}

type Person struct {
	Id bson.ObjectId `json:"id" bson:"_id"`
	Nombre string `json:"nombre" bson:"nombre"`
	Foto string `json:"foto" bson:"foto"`
}

func (person *Person) SetID(id bson.ObjectId) error {
	person.Id = id
	return nil
}

type Pool struct {
	Id_user bson.ObjectId `json:"id_user" bson:"id_user"`
	Cuota	float64 `json:"cuota" bson:"cuota"`
	Id_party bson.ObjectId `json:"id_party" bson:"id_party"`
}

type RSVP struct{
	Id bson.ObjectId `json:"id" bson:"_id"`
	Id_usuario bson.ObjectId `json:"id" bson:"id_usr"`
	Id_party bson.ObjectId `json:"id" bson:"id_party"`
	Status int64 `json:"status" bson:"stat"`s
}