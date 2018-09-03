package scala

object Lists extends App {
  val фрукты = "яблоки" :: ("апельсины" :: ("груши" :: Nil))
  val числа = Nil

  println( "'Голова' списка фруктов: " + фрукты.head )
  println( "'Хвост'  списка фруктов: " + фрукты.tail )
  println( "Список фруктов пуст?: " + фрукты.isEmpty )
  println( "Список чисел   пуст?: " + числа.isEmpty )
}

object ListsConcat extends App {
  val фрукты1 = "яблоки" :: ("апельсины" :: ("груши" :: Nil))
  val фрукты2 = "манго"  :: ("банан" :: Nil)

  // :::
  var фрукты = фрукты1 ::: фрукты2
    println( "фрукты1 ::: фрукты2 : " + фрукты )

  // List.:::() 
  фрукты = фрукты1.:::(фрукты2)
    println( "фрукты1.:::(фрукты2) : " + фрукты )

  // List.concat(List[F], List[F])
  фрукты = List.concat(фрукты1, фрукты2)
    println( "List.concat(фрукты1, фрукты2) : " + фрукты  )
}


object UniformListsCreation extends App {
    val фрукты = List.fill(3)("яблоки") // Повторяет яблоки 3 раза.
    println( "фрукты : " + фрукты  )
}

object TabulatingAFunction extends App {
  val квадраты = List.tabulate(6)(n => n * n)  // Создает 5 элементов, используя заданную функцию.
    println( "квадраты : " + квадраты  )       // вывод: "квадраты : List(0, 1, 4, 9, 16, 25)"

  val умнож = List.tabulate( 4,5 )( _ * _ )
    println( "умнож : \n" + умнож  )           // вывод: "умнож :
                                               // List(List(0, 0, 0, 0, 0),
                                               // List(0, 1, 2, 3, 4),
                                               // List(0, 2, 4, 6, 8),
                                               // List(0, 3, 6, 9, 12))"
}

