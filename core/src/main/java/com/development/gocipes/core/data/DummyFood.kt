package com.development.gocipes.core.data

import com.development.gocipes.core.model.Cook
import com.development.gocipes.core.model.Food
import com.development.gocipes.core.model.Ingredient

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

    val dummyAllFood = listOf(
        Food(
            id = 1,
            name = "Sandwich",
            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/sandwitch%203.jpeg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 2,
            name = "Sayur Bayam",
            imageUrl = "https://raw.githubusercontent.com/GoCipes/Resources/main/assets/Sayur%20Bening%20Bayam.jpeg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 3,
            name = "Salad Buah",
            imageUrl = "https://www.frisianflag.com/storage/app/media/uploaded-files/salad-buah-yoghurt.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 4,
            name = "Oatmeal",
            imageUrl = "https://i.ndtvimg.com/i/2016-10/oats-620_620x350_81477570522.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 5,
            name = "Salmon",
            imageUrl = "https://asset.kompas.com/crops/vYkHwPjb4vTgIA5P07jR6JUsAok=/0x0:1000x667/750x500/data/photo/2020/06/25/5ef406be7464f.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 6,
            name = "Bubur Kacang Hijau",
            imageUrl = "https://cdn1-production-images-kly.akamaized.net/s9PhuSwJmRlohGmLO9pv24IuYMU=/469x260/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/2558292/original/062688300_1546055941-shutterstock_426965845.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 7,
            name = "Tempe Orek",
            imageUrl = "https://asset.kompas.com/crops/yVU4FOVQhlwB5tGAvNUtMqU_dg8=/0x0:1000x667/750x500/data/photo/2023/01/04/63b4c955ae458.jpeg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 8,
            name = "Sup Ayam",
            imageUrl = "https://www.frisianflag.com/storage/app/media/uploaded-files/sop-ayam-sederhana.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 9,
            name = "Sup Sayur",
            imageUrl = "https://www.frisianflag.com/storage/app/media/uploaded-files/sop-baso.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 10,
            name = "Tempe Bacem",
            imageUrl = "https://paxelmarket.co/wp-content/uploads/2021/08/tempe-bacem-keluarga-isi-10-pcs.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 11,
            name = "Cap Cay",
            imageUrl = "https://www.frisianflag.com/storage/app/media/uploaded-files/sayur-capcay-kuah.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 12,
            name = "Telur Balado",
            imageUrl = "https://kurio-img.kurioapps.com/21/03/03/e8954a8a-c63d-4a80-a1ad-154473c6f4c4.jpe",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 13,
            name = "Telur Dadar",
            imageUrl = "https://cdn0-production-images-kly.akamaized.net/96cejMLvediHcW0OKb8XJFV2174=/0x0:1920x1082/800x450/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/2559225/original/035309500_1546271126-kitchen-775746_1920.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 14,
            name = "Bihun Goreng",
            imageUrl = "https://asset.kompas.com/crops/rfAN2frid2RjzIKUrsfPiYnuG8w=/539x0:5603x3376/750x500/data/photo/2022/03/07/62254d46a6be1.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 15,
            name = "Tongseng Daging",
            imageUrl = "https://asset.kompas.com/crops/-UPU2g2EDTsWjuHthk_WNUUGkns=/0x9:680x462/750x500/data/photo/2020/06/23/5ef1e941f232b.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
        Food(
            id = 16,
            name = "Rendang",
            imageUrl = "https://asset.kompas.com/crops/YKSBLbCigyp8uVtrfdqq57cS4Is=/0x3:977x654/750x500/data/photo/2020/06/30/5efaf91e0ec2c.jpg",
            description = "",
            minutes = "",
            category = "",
            ingredients = listOf(),
            step = listOf()
        ),
    )
}