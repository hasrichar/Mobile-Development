package com.development.gocipes.core.data.remote.response.article

data class ArtikelResponse(
	val msg: String,
	val code: Int,
	val data: List<ArtikelItem>,
	val status: String
)

data class ArtikelItem(
	val penulis: String,
	val idKategori: Int,
	val sumber: String,
	val id: Int,
	val headline: String,
	val gambar: String,
	val isi: String
)

