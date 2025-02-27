package org.coffee.data


import coffeeappkmp.composeapp.generated.resources.Res
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource


@Serializable
data class CoffeeModel(
    val id: Int=0,
    val title: String="",
    val desc: String="",
    val star: Double=5.3,
    var rating: String="23224",
    val price: Double=5.3,
    val imageUrl:String="f2",
) {
    companion object {
        fun getListCoffee(): List<CoffeeModel> {
            return listOf(
                CoffeeModel(1, "Espresso", "A strong shot of espresso", 4.5, "190", 2.5, "https://example.com/espresso.jpg"),
                CoffeeModel(2, "Cappuccino", "A combination of espresso, steamed milk, and foam", 4.8, "290", 3.5, "https://example.com/cappuccino.jpg"),
                CoffeeModel(3, "Latte", "A combination of espresso and steamed milk", 4.2, "401", 3.0, "https://example.com/latte.jpg"),
                CoffeeModel(4, "Mocha", "A variant of latte made with chocolate syrup or cocoa powder", 4.6, "530", 3.8, "https://example.com/mocha.jpg"),
                CoffeeModel(5, "Americano", "Espresso diluted with hot water", 4.1, "600", 2.8, "https://example.com/americano.jpg"),
                CoffeeModel(6, "Macchiato", "A shot of espresso 'marked' with a small amount of milk", 4.4, "900", 3.2, "https://example.com/macchiato.jpg"),
                CoffeeModel(7, "Breve", "A latte made with steamed half-and-half instead of milk", 4.7, "1500", 4.2, "https://example.com/breve.jpg"),
                CoffeeModel(8, "Flat White", "A double shot of espresso topped with a thin layer of microfoam", 4.9, "1800", 4.5, "https://example.com/flatwhite.jpg"),
                CoffeeModel(9, "Cortado", "Equal parts espresso and milk", 4.3, "1000", 3.5, "https://example.com/cortado.jpg"),
                CoffeeModel(10, "Cold Brew", "A type of coffee that is brewed without heat", 4.7, "2000", 4.0, "https://example.com/coldbrew.jpg"),
            )
        }
    }
}