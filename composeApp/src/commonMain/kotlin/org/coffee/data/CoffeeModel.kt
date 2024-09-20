package org.coffee.data


import kotlinx.serialization.Serializable


@Serializable
data class CoffeeModel(
    val id: Int=0,
    val title: String="",
    val desc: String="",
    val star: Double=5.3,
    var rating: String="23224",
    val price: Double=5.3
) {
    companion object {
        fun getListCoffee(): List<CoffeeModel> {
            return listOf(
                CoffeeModel(
                    1,
                    "Café au lait",
                    "For a French twist on your morning cup, try this recipe using equal parts coffee and milk. It’s typically made with dark roasted coffee",
                    3.4,
                    "2323",
                    343.30
                ),

                CoffeeModel(
                    2,
                    "Dirty chai latte",
                    "Upgrade your at-home barista skills with a comforting twist on a chai latte. It has a splash of coffee and is finished with a sprinkle of nutmeg",
                    3.4,
                    "2323",
                    343.30
                ),
                CoffeeModel(
                    3,
                    "Our best coffee recipes",
                    "Celebrate the irresistible flavour of coffee in our range of espresso cocktails and iced drinks or munch on cappuccino cakes, tiramisu, ice creams and more.",
                    3.4,
                    "2323",
                    943.10
                ),
                CoffeeModel(
                    4,
                    "Coffee granita",
                    "",
                    3.4,
                    "323",
                    543.00
                ),
                CoffeeModel(
                    5,
                    "Espresso mud ",
                    "To finish your meal try this take on coffee and dessert, and if you have any coffee liqueur in the back of the drinks cabinet, put a splash in the syrup",
                    3.4,
                    "2323",
                    343.30
                ),
                CoffeeModel(
                    6,
                    "Best reusable coffee cups",
                    "Kane Statton, coffee roaster and head barista at Nude Espresso in London, shares his tips for perfecting that milky froth when making a cup at home.",
                    3.4,
                    "2323",
                    343.30
                ),
                CoffeeModel(
                    7,
                    "Café au lait",
                    "Actually healthy, can caffeine boost energy and performance, and how much is too much? We look at the science behind the health claims",
                    3.4,
                    "2323",
                    343.30
                )
            )
        }
    }
}