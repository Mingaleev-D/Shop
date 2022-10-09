package studev

fun main() {

//    println("Enter shop name: ")
//    val shopName = readLine()
//    println("Shop name is: $shopName")


    val productNames = mutableListOf<String>()
    val productPrices = mutableListOf<String>()

    do{
        println("Enter product name: ")
        val productName = readLine()!!
        productNames.add(productName)

        println("Enter product price: ")
        val productPrice = readLine()!!
        productPrices.add(productPrice)

        println(" do you want do define another product? yes/no")
        val answer = readLine()!!

    } while (answer != "no")

    println("Enter customer name: ")
    val customerName = readLine()!!

    val itemProductsNames = mutableListOf<String>()
    val itemAmounts = mutableListOf<String>()

    do{
        println("Enter item product: ")
        val itemProductName = readLine()!!
        itemProductsNames.add(itemProductName)

        println("Enter amount of item: ")
        val itemAmount = readLine()!!
        itemAmounts.add(itemAmount)


        println(" Is there any item? yes/no")
        val answer = readLine()!!

    } while (answer != "no")

    var indexOfItemProductNames = 0

    do {
        val thisItemProductName = itemProductsNames[indexOfItemProductNames]
        val thisItemProductAmount = itemAmounts[indexOfItemProductNames]

        indexOfItemProductNames++

        println("item $itemProductsNames is $thisItemProductAmount of $thisItemProductName")

    }while (indexOfItemProductNames < itemProductsNames.size)


}