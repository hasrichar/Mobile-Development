package com.development.gocipes.data

import com.development.gocipes.model.Food

object DummyFood {
    val dummyFood = listOf(
        Food(
            id = 1,
            name = "Sandwich",
            minutes = "2-3 Menit",
            imageUrl = "https://food-images.files.bbci.co.uk/food/recipes/tiktok_breakfast_42301_16x9.jpg"
        ),
        Food(
            id = 2,
            name = "Sayur Bayam",
            minutes = "26 Menit",
            imageUrl = "https://static.promediateknologi.id/crop/0x0:0x0/750x500/webp/photo/2022/11/23/468459861.jpg"
        ),
        Food(
            id = 3,
            name = "Sayur Kangkung",
            minutes = "15-20 Menit",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2022/08/24051133/X-Tips-Kreatif-agar-Anak-Suka-Makan-Sayur-Kangkung.jpg"
        )
    )
}