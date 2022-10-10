package studev

import java.io.File
import kotlin.system.exitProcess

val itemProductsNames = mutableListOf<String>()
val itemAmounts = mutableListOf<Int>()

val productNames = mutableListOf<String>()
val productPrices = mutableListOf<Int>()

var shopName = ""
var customerNames = mutableListOf<String>()

val productList = mutableListOf<Product>()


class Product {
   var name = ""
   var price = 0

   constructor() {

   }
}

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

      createSingleProduct()

      val answer = askUntilYesOrNo("do you want do define another product? ")

   } while (answer != "no")
}

fun createSingleProduct() {

   val product = Product()

   val productName = askForStringFromUser("Enter product name: ")
   product.name = productName

   val productPrice = askForNumberFromUser("Enter product price: ")
   product.price = productPrice

   productList.add(product)
}

fun askForStringFromUser(message: String): String {
   println(message)
   return readLine()!!
}

fun askForNumberFromUser(message: String): Int {
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

      println(
         "item $itemProductsNames is " +
             "$itemProductAmountAtThisIndex of " +
             "$itemProductNameAtThisIndex -> $itemProductAmountAtThisIndex * $itemProductUnitPrice = " +
             "$totalPriceOfThisItem"
      )

   } while (indexOfItemProductNames < itemProductsNames.size)
   println("Total price = $totalPriceOfReceipt")
}

fun getPriceOfProduct(productName: String): Int {
   var index = 0
   do {
      if (productNames[index] == productName)
         return productPrices[index]

      index++
   } while (index < productNames.size)

   return 0
}

fun createNewCustomer() {
   val customerName = askForStringFromUser("Enter customer name")
   customerNames.add(customerName)
}

fun changeShopName() {
   shopName = askForStringFromUser("Enter shop name: ")
}

fun showMainMenu() {
   val menu = """
   Main menu.
      
   0-Change Shop Name
   1-Create New Product
   2-Create New Customer
   3-Creating Shopping cart
   4-Modify Product
   5-Modify Customer
   6-Print Product List
   7-Print Customer List
   8-Print Product Purchases List
      
   Please number(0-8) or exit:
      
   """.trimIndent()

   val answer = askForStringFromUser(menu)

   when (answer) {
      "0" -> changeShopName()
      "1" -> createSingleProduct()
      "2" -> createNewCustomer()
      "6" -> printProductList()
      "7" -> printingTheCustomerList()
      "exit" -> exitProcess(0)
      else -> println("pls enter number 0 or 8 or exit")
   }
}

fun printProductList() {
   if (productList.size < 1) {
      println("There is no product")
      return
   }
   for (p in productList)
      println("Product > ${p.name}, ${p.price}")

   println("------------------------------------")
}

fun printingTheCustomerList() {
   if (customerNames.size < 1) {
      println("There is no customer ...")
      return
   }

   println("List of Customer")

   for (cn in customerNames) {
      println("customer: $cn")
   }
   println("------------------------------------")
}

fun storeToPersistence() {
   val storeFile = File("C:/Users/admin/IdeaProjects/Shop/shop_test.txt")
   var data = ""

   for (product in productList) {
      data += "${product.name}|${product.price}"
      data += "+"
   }
   storeFile.writeText(data)
}

fun main() {

   restoreDataFromPersistence()

   while (true) {
      showMainMenu()
      storeToPersistence()


   }
}

fun restoreDataFromPersistence() {
   val storeFile = File("C:/Users/admin/IdeaProjects/Shop/shop_test.txt")
   val contentOfFile = storeFile.readText()

   var productName = ""
   var productPrice = ""
   var readingName = true

   for (ch in contentOfFile) {
      if (ch == '|') {
         readingName = false
      } else if (ch == '+') {
         readingName = true
         val product = Product()
         product.name = productName
         product.price = productPrice.toInt()

         productList.add(product)

         productName = ""
         productPrice = ""
      } else {
         if (readingName)
            productName += ch
         else
            productPrice += ch
      }
   }
}



