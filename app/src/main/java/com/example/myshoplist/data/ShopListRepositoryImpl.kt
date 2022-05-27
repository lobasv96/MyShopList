package com.example.myshoplist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myshoplist.domain.ShopItem
import com.example.myshoplist.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl: ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {

        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItemOnId(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItemOnId(id: Int): ShopItem {
        return shopList.find {
            it.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }
    //возвращать коллекцию не хорошо так как
    // мы можем иметь к ней доступ и редактировать из других мест программы, поэтому
    // возвращаем копию этой коллекции ( .toList  - создать копию листа )
    override fun getShopList(): LiveData <List<ShopItem>> {
        return shopListLD
    }

    //теперь при удалении, добавлении или редактировании элемента нам нужно
    // обновлять нашу ливдату
    // создаем метод
    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}