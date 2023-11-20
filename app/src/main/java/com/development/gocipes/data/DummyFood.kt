package com.development.gocipes.data

import com.development.gocipes.model.Cook
import com.development.gocipes.model.Food
import com.development.gocipes.model.Ingredient

object DummyFood {
    val dummyFood = listOf(
        Food(
            id = 1,
            name = "Sandwich",
            description = "\t\t\tSandwich merupakan sajian berupa dua potong roti yang didalamnya berisi daging, berbagai jenis sayuran, keju, ditambah dengan saus tomat atau mayonais.",
            minutes = "2-3 Menit",
            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/sandwitch%203.jpeg",
            category = "Roti",
            ingredients = listOf(
                Ingredient(
                    id = 1,
                    description = "250 gram bayam segar, cuci dan potong-potong"
                ),
                Ingredient(
                    id = 2,
                    description = "2 siung bawang putih, cincang halus"
                ),
                Ingredient(
                    id = 3,
                    description = "1 sdm minyak sayur"
                ),
                Ingredient(
                    id = 4,
                    description = "1/2 sdt garam (sesuai selera)"
                ),
                Ingredient(
                    id = 5,
                    description = "1/4 sdt merica (sesuai selera)"
                ),
                Ingredient(
                    id = 6,
                    description = "Air secukupnya"
                )
            ),
            step = listOf(
                Cook(
                    id = 1,
                    description = "Cuci bayam dengan baik dalam air mengalir dan buang batang yang keras.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/cuci-bayam.png",
                    minutes = 1
                ),
                Cook(
                    id = 2,
                    description = "Potong bayam menjadi bagian-bagian yang lebih kecil.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/potong-bayam.png",
                    minutes = 3
                ),
                Cook(
                    id = 3,
                    description = "Cincang halus bawang putih.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/cincang-bawah.png",
                    minutes = 4
                ),
                Cook(
                    id = 4,
                    description = "Panaskan satu sendok makan minyak sayur dalam wajan besar di atas api sedang (2 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/panaskan-minyak.png",
                    minutes = 15
                ),
                Cook(
                    id = 5,
                    description = "Tambahkan bawang putih cincang halus ke dalam minyak panas.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/tiris.png",
                    minutes = 10
                ),
                Cook(
                    id = 6,
                    description = "Setelah bawang putih telah berubah warna, tambahkan potongan bayam ke dalam wajan.... (6-8 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/rebus-bayam.png",
                    minutes = 8
                ),
                Cook(
                    id = 7,
                    description = "Taburkan garam sesuai selera dan merica di atas bayam. Aduk rata (1-2 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/tabur-bawang.png",
                    minutes = 18
                ),
                Cook(
                    id = 8,
                    description = "Tuangkan sedikit air ke dalam wajan (sekitar 2-3 sendok makan) untuk membantu proses masak dan menciptakan...(3-4 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/tuang-air.png",
                    minutes = 5
                )
            )
        ),
        Food(
            id = 2,
            name = "Sayur Bayam",
            minutes = "26 Menit",
            description = "\t\t\tBayam merupakan salah satu tumbuhan yang sering ditanam untuk dijadikan sayuran hijau. Daun bayam ini dikonsumsi karena kandungan nutrisi yang bergizi. Dalam setiap 100 gram daun bayam, terdapat sekitar 2.3 gram protein, 3.2 gram karbohidrat, 3 gram besi, dan 81 gram kalsium. Selain itu, bayam juga mengandung berbagai jenis vitamin dan mineral, seperti vitamin A, vitamin C, niasin, thiamin, fosfor, riboflavin, natrium, kalium, dan magnesium. Bayam merupakan sumber nutrisi yang kaya dan bermanfaat bagi kesehatan.",
            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/Sayur%20Bening%20Bayam.jpeg",
            category = "Sayur",
            ingredients = listOf(
                Ingredient(
                    id = 1,
                    description = "250 gram bayam segar, cuci dan potong-potong"
                ),
                Ingredient(
                    id = 2,
                    description = "2 siung bawang putih, cincang halus"
                ),
                Ingredient(
                    id = 3,
                    description = "1 sdm minyak sayur"
                ),
                Ingredient(
                    id = 4,
                    description = "1/2 sdt garam (sesuai selera)"
                ),
                Ingredient(
                    id = 5,
                    description = "1/4 sdt merica (sesuai selera)"
                ),
                Ingredient(
                    id = 6,
                    description = "Air secukupnya"
                )
            ),
            step = listOf(
                Cook(
                    id = 1,
                    description = "Cuci bayam dengan baik dalam air mengalir dan buang batang yang keras.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/cuci-bayam.png",
                    minutes = 4
                ),
                Cook(
                    id = 2,
                    description = "Potong bayam menjadi bagian-bagian yang lebih kecil.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/potong-bayam.png",
                    minutes = 9
                ),
                Cook(
                    id = 3,
                    description = "Cincang halus bawang putih.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/cincang-bawah.png",
                    minutes = 5
                ),
                Cook(
                    id = 4,
                    description = "Panaskan satu sendok makan minyak sayur dalam wajan besar di atas api sedang (2 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/panaskan-minyak.png",
                    minutes = 2
                ),
                Cook(
                    id = 5,
                    description = "Tambahkan bawang putih cincang halus ke dalam minyak panas.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/tiris.png",
                    minutes = 10
                ),
                Cook(
                    id = 6,
                    description = "Setelah bawang putih telah berubah warna, tambahkan potongan bayam ke dalam wajan.... (6-8 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/rebus-bayam.png",
                    minutes = 7
                ),
                Cook(
                    id = 7,
                    description = "Taburkan garam sesuai selera dan merica di atas bayam. Aduk rata (1-2 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/tabur-bawang.png",
                    minutes = 2
                ),
                Cook(
                    id = 8,
                    description = "Tuangkan sedikit air ke dalam wajan (sekitar 2-3 sendok makan) untuk membantu proses masak dan menciptakan...(3-4 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/tuang-air.png",
                    minutes = 3
                )
            )
        ),
        Food(
            id = 3,
            name = "Sayur Kangkung",
            description = "\t\t\tKangkung menjadi salah satu sayuran yang tidak kenal musim dan mudah ditemukan. Rasanya lezat sekaligus sangat mudah untuk diolah menjadi berbagai menu makanan. Tak hanya itu, sayuran ini mengandung banyak nutrisi sehingga dapat memberikan banyak manfaat.",
            minutes = "15-20 Menit",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2022/08/24051133/X-Tips-Kreatif-agar-Anak-Suka-Makan-Sayur-Kangkung.jpg",
            category = "Sayur",
            ingredients = listOf(
                Ingredient(
                    id = 1,
                    description = "250 gram bayam segar, cuci dan potong-potong"
                ),
                Ingredient(
                    id = 2,
                    description = "2 siung bawang putih, cincang halus"
                ),
                Ingredient(
                    id = 3,
                    description = "1 sdm minyak sayur"
                ),
                Ingredient(
                    id = 4,
                    description = "1/2 sdt garam (sesuai selera)"
                ),
                Ingredient(
                    id = 5,
                    description = "1/4 sdt merica (sesuai selera)"
                ),
                Ingredient(
                    id = 6,
                    description = "Air secukupnya"
                )
            ),
            step = listOf(
                Cook(
                    id = 1,
                    description = "Cuci bayam dengan baik dalam air mengalir dan buang batang yang keras.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/cuci-bayam.png",
                    minutes = 5
                ),
                Cook(
                    id = 2,
                    description = "Potong bayam menjadi bagian-bagian yang lebih kecil.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/potong-bayam.png",
                    minutes = 3
                ),
                Cook(
                    id = 3,
                    description = "Cincang halus bawang putih.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/cincang-bawah.png",
                    minutes = 5
                ),
                Cook(
                    id = 4,
                    description = "Panaskan satu sendok makan minyak sayur dalam wajan besar di atas api sedang (2 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/panaskan-minyak.png",
                    minutes = 2
                ),
                Cook(
                    id = 5,
                    description = "Tambahkan bawang putih cincang halus ke dalam minyak panas.",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/tiris.png",
                    minutes = 1
                ),
                Cook(
                    id = 6,
                    description = "Setelah bawang putih telah berubah warna, tambahkan potongan bayam ke dalam wajan.... (6-8 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/rebus-bayam.png",
                    minutes = 8
                ),
                Cook(
                    id = 7,
                    description = "Taburkan garam sesuai selera dan merica di atas bayam. Aduk rata (1-2 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/tabur-bawang.png",
                    minutes = 4
                ),
                Cook(
                    id = 8,
                    description = "Tuangkan sedikit air ke dalam wajan (sekitar 2-3 sendok makan) untuk membantu proses masak dan menciptakan...(3-4 menit).",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/tuang-air.png",
                    minutes = 3
                )
            )
        )
    )
}