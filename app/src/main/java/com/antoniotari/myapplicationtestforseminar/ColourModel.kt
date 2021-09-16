package com.antoniotari.myapplicationtestforseminar

import com.google.gson.annotations.SerializedName

data class ColourModel(@SerializedName("id")val id: Int,
                       @SerializedName("uid")val uid: String,
                       @SerializedName("hex_value") val hexValue: String,
                       @SerializedName("color_name") val colourName: String
                       /*@SerializedName("hsl_value")val hslValue: List<Float>,
                       @SerializedName("hsla_value")val hslaValue: List<Float>*/)
