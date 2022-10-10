package studev

val itemProductsNames = mutableListOf<String>()
val itemAmounts = mutableListOf<Int>()

val productNames = mutableListOf<String>()
val productPrices = mutableListOf<Int>()

fun askUntilYesOrNo(message: String): String {
   println("$message yes/no")
   var answer = readLine()!!

   while (answer != "yes" || answer != "no") {
      println(message)
      println("please only enter yes or no")
      answer = readLine()!!
   }
   return answer
}

fun createProducts() {
   do {

      val productName = askForStringFromUser("Enter product name: ")
      productNames.add(productName)


      val productPrice = askForNumberFromUser("Enter product price: ")
      productPrices.add(productPrice)

      val answer = askUntilYesOrNo("do you want do define another product? ")

   } while (answer != "no")
}
fun askForStringFromUser(message:String):String{
   println(message)
   return readLine()!!
}
fun askForNumberFromUser(message:String):Int{
val string = askForStringFromUser(message)
  return string.toInt()
}

fun askTheItemsOfShoppingCart() {
   do {

      val itemProductName = askForStringFromUser("Enter item product: ")
      itemProductsNames.add(itemProductName)


      val itemAmount = askForNumberFromUser("Enter amount of item: ")
      itemAmounts.add(itemAmount)

      val answer = askUntilYesOrNo(" Is there any item? ")

   } while (answer != "no")
}

fun printTheFinalReceipt() {
   var indexOfItemProductNames = 0
   var totalPriceOfReceipt = 0

   do {
      val itemProductNameAtThisIndex = itemProductsNames[indexOfItemProductNames]
      val itemProductAmountAtThisIndex = itemAmounts[indexOfItemProductNames]

      val itemProductUnitPrice = getPriceOfProduct(itemProductNameAtThisIndex)
      val totalPriceOfThisItem = itemProductAmountAtThisIndex * itemProductUnitPrice

      totalPriceOfReceipt = totalPriceOfReceipt + totalPriceOfThisItem

      indexOfItemProductNames++

      println("item $itemProductsNames is " +
          "$itemProductAmountAtThisIndex of " +
          "$itemProductNameAtThisIndex -> $itemProductAmountAtThisIndex * $itemProductUnitPrice = " +
          "$totalPriceOfThisItem")

   } while (indexOfItemProductNames < itemProductsNames.size)
   println("Total price = $totalPriceOfReceipt")
}

fun getPriceOfProduct(productName: String): Int {
   var index = 0
   do{
      if (productNames[index] == productName)
         return productPrices[index]

      index++
   }while (index < productNames.size)

   return 0
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



