package com.development.gocipes.data

import com.development.gocipes.model.Category
import com.development.gocipes.model.Favorite

object DummyFavorite {
    val dummyFavorite = listOf(
        Favorite(
            id = 1,
            name = "Nasi Goreng",
            imageUrl = "https://img.freepik.com/premium-photo/nasi-goreng-is-made-from-rice-shrimp-meatballs-with-spicy-spices-processed-by-frying_103127-2731.jpg",
            category = listOf(
                Category(
                    id = 1,
                    name = "Populer",
                    imageUrl = "https://img.freepik.com/free-vector/vector-cartoon-illustration-traditional-set-fast-food-meal_1441-331.jpg"
                ),
                Category(
                    id = 2,
                    name = "Sayuran",
                    imageUrl = "https://img.freepik.com/premium-vector/bowl-with-fresh-healthy-vegetables-vector-illustration_508931-17.jpg"
                ),
            )
        ),
        Favorite(
            id = 2,
            name = "Cah Kangkung",
            imageUrl = "https://img.freepik.com/premium-photo/tumis-kangkung-indonesian-food-photo_939987-30.jpg?size=626&ext=jpg&ga=GA1.1.1826414947.1699315200&semt=sph",
            category = listOf(
                Category(
                    id = 1,
                    name = "Sayuran",
                    imageUrl = "https://img.freepik.com/premium-vector/bowl-with-fresh-healthy-vegetables-vector-illustration_508931-17.jpg"
                )
            )
        ),
        Favorite(
            id = 3,
            name = "Mie pangsit",
            imageUrl = "https://img.freepik.com/premium-photo/bakmi-mie-ayam-noodles-with-chiken-served-with-dumpling-meat-ballindonesian-food_431906-1816.jpg",
            category = listOf(
                Category(
                    id = 1,
                    name = "Mie",
                    imageUrl = "https://static.vecteezy.com/system/resources/previews/010/556/470/original/mie-ayam-pangsit-indonesian-food-art-illustration-vector.jpg"
                )
            )
        ),
        Favorite(
            id = 4,
            name = "Jamu kunyit asam",
            imageUrl = "https://img.freepik.com/premium-photo/jamu-kunir-asem-kunyit-asam-is-indonesian-traditional-herbal-drink-made-from-turmeric-tamarin_581937-1033.jpg?w=360",
            category = listOf(
                Category(
                    id = 1,
                    name = "Jamu",
                    imageUrl = "https://png.pngtree.com/png-vector/20230508/ourlarge/pngtree-green-herbal-logo-vector-png-image_7088496.png"
                )
            )
        ),
    )
}