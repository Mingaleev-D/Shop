package studev

val itemProductsNames = mutableListOf<String>()
val itemAmounts = mutableListOf<String>()

fun askUntilYesOrNo(message: String): String {
   println(message)
   var answer = readLine()!!

   while (answer != "yes" || answer != "no") {
      println(message)
      println("please only enter yes or no")
      answer = readLine()!!
   }
   return answer
}

fun createProducts() {
   val productNames = mutableListOf<String>()
   val productPrices = mutableListOf<String>()

   do {
      println("Enter product name: ")
      val productName = readLine()!!
      productNames.add(productName)

      println("Enter product price: ")
      val productPrice = readLine()!!
      productPrices.add(productPrice)

      val answer = askUntilYesOrNo("do you want do define another product? yes/no")

   } while (answer != "no")
}

fun askTheItemsOfShoppingCart() {
   do {
      println("Enter item product: ")
      val itemProductName = readLine()!!
      itemProductsNames.add(itemProductName)

      println("Enter amount of item: ")
      val itemAmount = readLine()!!
      itemAmounts.add(itemAmount)

      val answer = askUntilYesOrNo(" Is there any item? yes/no")

   } while (answer != "no")
}

fun printTheFinalReceipt() {
   var indexOfItemProductNames = 0

   do {
      val thisItemProductName = itemProductsNames[indexOfItemProductNames]
      val thisItemProductAmount = itemAmounts[indexOfItemProductNames]

      indexOfItemProductNames++

      println("item $itemProductsNames is $thisItemProductAmount of $thisItemProductName")

   } while (indexOfItemProductNames < itemProductsNames.size)
}

fun askCustomerName() {
   println("Enter customer name: ")
   val customerName = readLine()!!
}

fun askShopName() {
   println("Enter shop name: ")
   val shopName = readLine()
}

fun main() {

   askShopName()

   createProducts()

   askCustomerName()

   askTheItemsOfShoppingCart()

   printTheFinalReceipt()

}



