package com.example.myshoplist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshoplist.data.ShopListRepositoryImpl
import com.example.myshoplist.domain.*

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    // создаем обьект livedata и помещаем в него список элементов
    val shopList = getShopListUseCase.getShopList()


    // удалить элемент из списка
    fun deleteShopItem (shopItem: ShopItem)  {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    // редактировать элемент (а именно поле enabled), потому что редактировать будем только
    //состояние обьекта - имя, число оставляем такие-же
    fun changeEnabledState (shopItem: ShopItem) {
        // данным способом (в нижней строке) будет создана копия обьекта
        val newItem = shopItem.copy(enabled = !shopItem.enabled) // используем именованный параметр
        // тоесть здесь будет создана полная копия данного обьекта, но у него состояние
        // enabled будет полностью противоположным чем у обьекта
        editShopItemUseCase.editShopItem(newItem)
    }

}