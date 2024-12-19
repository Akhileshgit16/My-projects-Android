package com.wsa.foodlazycolumn

data class FoodsClass(val foodimages:Int,val foodname:String,val fooddetails:String, val foodchains:String)

fun getAllFoodClass():ArrayList<FoodsClass>
{
    return arrayListOf(

        FoodsClass(R.drawable.margherita, foodname = "Margherita Pizza" ,
            fooddetails ="A dough base topped with tomato sauce, cheese, and various toppings.",
            foodchains = "Domino's, Pizza Hut, Papa John's, Little Caesars."),
        FoodsClass(R.drawable.frenchfries, foodname = "French Fries" ,
            fooddetails =" Deep-fried potato strips, crispy on the outside and soft inside, often served as a side dish or snack.",
        foodchains = "McDonald's, Wendy's, Five Guys, Shake Shack, Arby's."),
        FoodsClass(R.drawable.burger, foodname = "Chicken Burger" ,
            fooddetails ="A cooked beef or chicken patty in a bun with toppings like lettuce, cheese, and sauce.",
            foodchains = "McDonald's, Burger King, Five Guys, In-N-Out."),
        FoodsClass(R.drawable.blueberry_smoothie, foodname = "Blueberry Smoothie" ,
            fooddetails ="A blended drink made with fresh blueberries, yogurt, milk,often sweetened with honey. It's creamy, refreshing, and packed with antioxidants.",
            foodchains = "Smoothie King, Jamba Juice, Tropical Smoothie Cafe"),
        FoodsClass(R.drawable.wafflepng, foodname = "Choco Waffle" ,
            fooddetails ="A crispy, grid-patterned cake, usually served for breakfast with toppings like syrup.",
            foodchains = "IHOP, Waffle House, Belgian Waffle Co."),
        FoodsClass(R.drawable.donuts, foodname = "Donuts" ,
            fooddetails ="Sweet, fried dough pastries, often ring-shaped with sugar or icing.",
            foodchains = "Dunkin' Donuts, Krispy Kreme, Tim Hortons"),
        FoodsClass(R.drawable.milkshake, foodname = "Milk Shake" ,
            fooddetails ="A creamy drink made with milk, ice cream, and flavorings like chocolate or vanilla.",
            foodchains = "McDonald's, Shake Shack, In-N-Out, Johnny Rockets"),
        FoodsClass(R.drawable.nachos, foodname = "Nachos" ,
            fooddetails ="Tortilla chips topped with melted cheese, salsa, and other toppings like jalapeños or sour cream.",
            foodchains = "Taco Bell, Chipotle, QDOBA"),
        FoodsClass(R.drawable.pasta, foodname = "Cheese Pasta" ,
            fooddetails ="Italian dish made from wheat dough, served with various sauces like marinara, Alfredo, or pesto.",
            foodchains = "Olive Garden, Carrabba's, Pasta House Co."),
        FoodsClass(R.drawable.potato, foodname = "Potato Wedges" ,
            fooddetails ="Thick-cut potato slices, often seasoned and baked or deep-fried, served as a side dish or snack.",
            foodchains = " KFC, Arby's, Wendy's"),
        FoodsClass(R.drawable.icecream, foodname = "Cone Ice Cream" ,
            fooddetails ="A cone-shaped wafer filled with scoops of ice cream, often topped with sprinkles, chocolate syrup, or whipped cream.",
            foodchains = "Dairy Queen, Baskin-Robbins, Ben & Jerry's, Cold Stone Creamery")





    )

}