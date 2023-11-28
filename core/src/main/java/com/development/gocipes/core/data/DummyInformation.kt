package com.development.gocipes.core.data

import com.development.gocipes.core.model.Information

object DummyInformation {
    val dummyArticle = listOf(
        Information(
            id = 1,
            name = "Pentingnya Gizi Seimbang bagi tubuh",
            description = "Gizi seimbang merupakan susunan pangan sehari-hari yang mengandung zat gizi dalam jenis dan jumlah yang sesuai dengan kebutuhan tubuh, dengan memperhatikan prinsip keanekaragaman pangan, aktifitas fisik, perilaku hidup bersih dan mempertahankan berat badan normal secara teratur.\n" +
                    "Gizi seimbang yaitu apabila asupan makan cukup secara kuantitas, kualitas dan mengandung berbagai zat gizi yang dibutuhkan tubuh. Tujuannya agar kesehatan tubuh terjaga, pertumbuhan sempurna (pada anak-anak), zat gizi tersimpan, dan aktifitas dan fungsi sehari-hari berjalan optimal",
            imageUrl = "https://diskes.badungkab.go.id/storage/diskes/image/GIZI%20SEIMBANG.png"
        ),
        Information(
            id = 2,
            name = "Mengapa Gizi Seimbang itu Penting?",
            description = "",
            imageUrl = "https://www.tanotofoundation.org/wp-content/uploads/2022/01/WhatsApp-Image-2022-01-18-at-14.42.44-1-1024x768.jpeg"
        )
    )

    val dummyTechnique = listOf(
        Information(
            id = 1,
            name = "Cara memegang pisau yang mahir",
            description = "",
            imageUrl = "https://www.dictio.id/uploads/db3342/original/3X/2/7/27e5072305accd71a09957761e6e511bfeb183ac.jpg",
            videoUrl = "B43ji9RgbZI",
            listPractice = listOf(
                "Pegang pisau dengan seluruh jari mencengkram gagangnya. Posisikan ibu jari tepat di bagian ujung belakang mata pisau yang dekat dengan gagang.",
                "Saat memotong, pastikan tangan satu lagi memegang bahan makanan. Supaya aman, lindungi ujung jari dengan menekuknya ke dalam seperti sedang mencakar, sementara buku jari yang menonjol memandu pisau dan melindungi jari lain saat memotong makanan.",
                "Pastikan Anda santai dan pergelangan tangan tidak kaku, saat memotong bahan masakan. Biarkan ketajaman pisau bekerja.",
                "Jika semua jari memegang gagang pisau,  saat memotong bahan masakan yang keras pisau bisa oleng dan melukai tangan karena sulit dikontrol."
            )
        ),
        Information(
            id = 2,
            name = "Cara mengiris bawang agar tidak menangis",
            description = "",
            imageUrl = "https://cdn-brilio-net.akamaized.net/news/2019/03/01/160204/750xauto-12-cara-memotong-bawang-merah-tanpa-bikin-mata-menangis-1903017.jpg",
            videoUrl = "woN939X4kk8",
            listPractice = listOf(
                "Dinginkan Sebelum Dipotong",
                "Potong di dalam Air",
                "Pilih Pisau Anti Karat",
                "Nyalakan Lilin Saat Memotong Bawang Merah",
                "Oleskan Talenan dengan Cuka",
                "Kenakan Kacamata Renang"
            )
        )
    )
}