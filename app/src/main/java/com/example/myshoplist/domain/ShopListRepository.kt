package com.example.myshoplist.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItemOnId(id: Int) : ShopItem

    fun getShopList() : List<ShopItem>
}