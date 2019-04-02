package service

import utility.ConverterUtility
import java.time.LocalDate

import database.HotelDatabase
import model.Hotel

class HotelService {
    def findCheapestHotel(hotelList:List[Hotel],customerType:String,dates:LocalDate*)={
      val dayCount=dates.map(date=>ConverterUtility.getWeekpart(date))
                         .groupBy(identity)
                         .mapValues(x=>x.size)

      val getPriceMap=hotelList.map(hotel => hotel->hotel.getPrice(customerType,dayCount))

      val min=getPriceMap.minBy(_._2)._2

      val cheapestHotels=getPriceMap.filter(_._2==min)

      println("cheapest hotel  "+cheapestHotels)

      val cheapestHotelName=cheapestHotels.maxBy(_._1.rating)._1.name

      cheapestHotelName

  }

}

object HotelService extends App{
  val service=new HotelService
  println(service.findCheapestHotel(HotelDatabase.hotelList,"REGULAR",LocalDate.of(2009,3,16),    LocalDate.of(2009,3,17),LocalDate.of(2009,3,18)))

  println(service.findCheapestHotel(HotelDatabase.hotelList,"REGULAR",LocalDate.of(2009,3,20),    LocalDate.of(2009,3,21),LocalDate.of(2009,3,22)))

  println(service.findCheapestHotel(HotelDatabase.hotelList,"REWARD",LocalDate.of(2009,3,26),    LocalDate.of(2009,3,27),LocalDate.of(2009,3,28)))

}
