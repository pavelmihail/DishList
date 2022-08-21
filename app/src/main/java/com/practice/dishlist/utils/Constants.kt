package com.practice.dishlist.utils

object Constants {

    const val DISH_TYPE: String = "DishType"
    const val DISH_CATEGORY: String = "DishCategory"
    const val DISH_COOKING_TIME: String = "DishCookingTime"

    const val DISH_IMAGE_SOURCE_LOCAL : String  = "Local"
    const val DISH_IMAGE_SOURCE_ONLINE : String  = "Online"

    fun dishTypes(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("breakfast")
        list.add("lunch")
        list.add("snacks")
        list.add("dinner")
        list.add("side dish")
        list.add("dessert")
        list.add("other")

        return list
    }

    fun dishCategory(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("Pizza")
        list.add("BBQ")
        list.add("Burger")
        list.add("Chicken")
        list.add("Dessert")
        list.add("Hot Dogs")
        list.add("Juices")
        list.add("Sandwich")
        list.add("Coffee")
        list.add("other")

        return list
    }

    fun dishCookingTime(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("10")
        list.add("15")
        list.add("20")
        list.add("30")
        list.add("45")
        list.add("50")
        list.add("60")
        list.add("90")
        list.add("120")
        list.add("150")

        return list
    }


}