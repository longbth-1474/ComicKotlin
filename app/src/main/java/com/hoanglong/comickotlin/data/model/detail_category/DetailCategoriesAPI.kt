package com.hoanglong.comickotlin.data.model.detail_category

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DetailCategoriesAPI (
    @SerializedName("Comics")
    @Expose var comicsCategory: ComicsCategory
)