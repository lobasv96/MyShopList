package com.example.myshoplist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItemOnId(id: Int) : ShopItem

    fun getShopList() : LiveData<List<ShopItem>>
}