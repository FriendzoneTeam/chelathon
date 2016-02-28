package models

type Locations struct{
	Longitude int64
	Latitude int64
}

type Party struct{
	Id int
	Name string
	Location Locations
	Cover float64
	Fecha string
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