package models

type Locations struct{
	Longitude int64 `json:"longitude" bson:"longitude"`
	Latitude int64 `json:"latitude" bson:"latitude"`
}

type Party struct{
	Id int `json:"id"`
	Name string `json:"name" bson:"name"`
	Location Locations `json:"locations" bson:"locations"`
	Cover float64 `json:"cover" bson:"cover"`
	Fecha string `json:"fecha" bson:"fecha"`
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
	Id int `json:"id"`
	Nombre string `json:"nombre" bson:"nombre"`
	Foto string `json:"foto" bson:"foto"`
}

type Pool struct {
	Id int `json:"id"`
	Id_user int64 `json:"id_user" bson:"id_user"`
	Cuota	float64 `json:"cuota" bson:"cuota"`
	Id_party int64 `json:"id_party" bson:"id_party"`
}