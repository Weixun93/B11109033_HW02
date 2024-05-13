package com.example.b11109033_hw02

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class InfoVariable (
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val directions: Int,
    @StringRes val briefInfo: Int,
    val address: String
)

// Retrieve strings from res/string.xml in an Android application.
val ViewsInfo = listOf(
    InfoVariable(
        R.drawable.taichungmusich,
        R.string.siteName_1,
        R.string.siteDescription_1,
        R.string.briefInfo_1,
        "407025 台中市西屯區惠來路二段101號"
    ),
    InfoVariable(
        R.drawable.nationaltheatreh,
        R.string.siteName_2,
        R.string.siteDescription_2,
        R.string.briefInfo_2,
        "100 台北市中正區中山南路21-1號"
    ),
    InfoVariable(
        R.drawable.taipeiartm,
        R.string.siteName_3,
        R.string.siteDescription_3,
        R.string.briefInfo_3,
        "10491 台北市中山區中山北路三段181號"
    ),
    InfoVariable(
        R.drawable.taipeizoo,
        R.string.siteName_4,
        R.string.siteDescription_4,
        R.string.briefInfo_4,
        "116 台北市文山區新光路二段30號"
    ),
    InfoVariable(
        R.drawable.kcgzoo,
        R.string.siteName_5,
        R.string.siteDescription_5,
        R.string.briefInfo_5,
        "80444 高雄市鼓山區萬壽路350號"
    ),
    InfoVariable(
        R.drawable._022_06_07,
        R.string.siteName_6,
        R.string.siteDescription_6,
        R.string.briefInfo_6,
        "625 嘉義縣布袋鎮新西路5號"
    )

)