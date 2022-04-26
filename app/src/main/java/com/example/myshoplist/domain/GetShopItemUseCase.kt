package com.example.myshoplist.domain

class GetShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun getShopItemOnId(id: Int) : ShopItem {
        return shopListRepository.getShopItemOnId(id)
    }
}