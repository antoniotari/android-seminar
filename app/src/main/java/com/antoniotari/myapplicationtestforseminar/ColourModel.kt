package com.antoniotari.myapplicationtestforseminar

import com.google.gson.annotations.SerializedName

data class ColourModel(@SerializedName("id")val id: Int,
                       @SerializedName("uid")val uid: String,
                       @SerializedName("hex_value") val hexValue: String,
                       @SerializedName("color_name") val colourName: String
                       /*@SerializedName("hsl_value")val hslValue: List<Float>,
                       @SerializedName("hsla_value")val hslaValue: List<Float>*/)

/*
{
    "id":1310,
    "uid":"c2c45c16-aff3-4a8c-9e96-aded3c7144a3",
    "hex_value":"#61e3b9",
    "color_name":"periwinkle"
}
 */