package models

type Locations struct{
	Longitude int
	Latitude int
}

type Party struct{
	Id int
	Name string
	Location Locations
	Cover float
	fecha string
}

type Venue {
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
	Cuota	float
	id_party int
}