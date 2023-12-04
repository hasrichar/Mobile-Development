package com.development.gocipes.core.data

import com.development.gocipes.core.model.Category
import com.development.gocipes.core.model.Cook
import com.development.gocipes.core.model.Food
import com.development.gocipes.core.model.Ingredient

object DummyCategory {
    val dummyCategory = listOf(
        Category(
            id = 1,
            name = "Populer",
            imageUrl = "https://img.freepik.com/free-vector/vector-cartoon-illustration-traditional-set-fast-food-meal_1441-331.jpg",
            listFood = listOf(
                Food(
                    id = 1,
                    name = "Sandwich",
                    description = "\t\t\tSandwich merupakan sajian berupa dua potong roti yang didalamnya berisi daging, berbagai jenis sayuran, keju, ditambah dengan saus tomat atau mayonais.",
                    minutes = "2-3 Menit",
                    imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/sandwitch%203.jpeg",
                    category = "Roti",
                    fat = 8,
                    carbohydrates = 75,
                    protein = 17,
                    ingredients = listOf(
                        Ingredient(
                            id = 1,
                            description = "2 Slice Roti Tawar/Gandum"
                        ),
                        Ingredient(
                            id = 2,
                            description = "1 Slice Beef"
                        ),
                        Ingredient(
                            id = 3,
                            description = "1 slice keju mozzarella"
                        ),
                        Ingredient(
                            id = 4,
                            description = "1/4 bawang bombang"
                        ),
                        Ingredient(
                            id = 5,
                            description = "selada"
                        ),
                        Ingredient(
                            id = 6,
                            description = "tomat"
                        ),
                        Ingredient(
                            id = 7,
                            description = "Margarin"
                        ),
                        Ingredient(
                            id = 8,
                            description = "Saus Sambal(tomat)"
                        ),
                        Ingredient(
                            id = 9,
                            description = "Mayonnaise"
                        )
                    ),
                    step = listOf(
                        Cook(
                            id = 1,
                            description = "Panaskan pan / teflon yang telah dilumuri margarin",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/sd%201.jpeg",
                            minutes = 1
                        ),
                        Cook(
                            id = 2,
                            description = "Panggang roti dengan api kecil ",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/sd%202.jpeg",
                            minutes = 2
                        ),
                        Cook(
                            id = 3,
                            description = "Tambahkan selada,tomat dan keju",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/sd%204.jpeg",
                            minutes = 1
                        ),
                        Cook(
                            id = 4,
                            description = "Tambahkan beef ",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/sd%205.jpeg",
                            minutes = 1
                        ),
                        Cook(
                            id = 5,
                            description = "Tambahkan saus dan mayonaise sesuai selera",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/sd%206.jpeg",
                            minutes = 1
                        ),
                        Cook(
                            id = 6,
                            description = "Tutup dan panggang kembali sebentar hingga keju meleleh",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/sd%207.jpeg",
                            minutes = 8
                        ),
                        Cook(
                            id = 7,
                            description = "Sandwich siap disajikan",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/sd%209.jpeg",
                            minutes = 0
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
                    fat = 8,
                    carbohydrates = 75,
                    protein = 17,
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
                            minutes = 2
                        ),
                        Cook(
                            id = 2,
                            description = "Potong bayam menjadi bagian-bagian yang lebih kecil.",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/potong-bayam.png",
                            minutes = 5
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
                    fat = 8,
                    carbohydrates = 75,
                    protein = 17,
                    ingredients = listOf(
                        Ingredient(
                            id = 1,
                            description = "1.3 ikat kangkung,potong dan cuci "
                        ),
                        Ingredient(
                            id = 2,
                            description = "4 butir Bawang merah"
                        ),
                        Ingredient(
                            id = 3,
                            description = "2 siung bawang putih"
                        ),
                        Ingredient(
                            id = 4,
                            description = "2 Cabai keriting"
                        ),
                        Ingredient(
                            id = 5,
                            description = "2 Cabang rawit (sesuai selera)"
                        ),
                        Ingredient(
                            id = 6,
                            description = "Garam 1sdt"
                        ),
                        Ingredient(
                            id = 7,
                            description = "Gula pasir 1/2 sdt"
                        ),
                        Ingredient(
                            id = 8,
                            description = "Saus tiram 1sdm"
                        )
                    ),
                    step = listOf(
                        Cook(
                            id = 1,
                            description = "Iris tipis bawang merah,bawang putih,cabai rawit dan cabai keriting",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/kk%201.jpeg",
                            minutes = 2
                        ),
                        Cook(
                            id = 2,
                            description = "Tumis hingga harum",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/kk%202.jpeg",
                            minutes = 3
                        ),
                        Cook(
                            id = 3,
                            description = "Masukkan saus tiram 1sendok makan.",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/kk%203.jpeg",
                            minutes = 1
                        ),
                        Cook(
                            id = 4,
                            description = "Masukkan kangkung yang telah dicuci bersih dan dipotong memanjang (tunggu hingga layu dan lunak)",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/kk%204.jpeg",
                            minutes = 5
                        ),
                        Cook(
                            id = 5,
                            description = "Cah kangkung siap disajikan",
                            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/kk%205.jpeg",
                            minutes = 1
                        )
                    )
                )
            )
        ),
        Category(
            id = 2,
            name = "Sayuran",
            imageUrl = "https://img.freepik.com/premium-vector/bowl-with-fresh-healthy-vegetables-vector-illustration_508931-17.jpg",
            listFood = listOf()
        ),
        Category(
            id = 3,
            name = "Roti",
            imageUrl = "https://img.freepik.com/premium-vector/floating-bread-toast-cartoon-vector-icon-illustration-food-object-icon-concept-isolated-flat_138676-4308.jpg",
            listFood = listOf()
            ),
        Category(
            id = 4,
            name = "Jamu",
            imageUrl = "https://png.pngtree.com/png-vector/20230508/ourlarge/pngtree-green-herbal-logo-vector-png-image_7088496.png",
            listFood = listOf()
        ),
        Category(
            id = 5,
            name = "Mie",
            imageUrl = "https://static.vecteezy.com/system/resources/previews/010/556/470/original/mie-ayam-pangsit-indonesian-food-art-illustration-vector.jpg",
            listFood = listOf()
        )
    )
}