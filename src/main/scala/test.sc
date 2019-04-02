import java.time.LocalDate






def getWeekpart(date:LocalDate)=date.getDayOfWeek.getValue match {
  case 1|2|3|4|5 => 0
  case 6|7 => 1
  case _ => -1

}

def findCheapestHotel(customerType:String,dates:LocalDate*)={
  val dayValues=dates.map(date=>getWeekpart(date))
  println(dayValues)
  val getcount=dayValues.groupBy(identity).mapValues(x=>x.size)
  println(getcount)
  getcount
}

findCheapestHotel("hi", LocalDate.of(2019,2, 24), LocalDate.of(2019,2,21))


class Hotel(var name:String,var rating:Int,var wdRegular:Int,var wdReward:Int,var weRegular:Int,var weReward:Int){

  def getPrice(customerType:String,map: Map[Int,Int])=customerType match{
    case "REGULAR"=>getRegularPrice(map.values.toList(0))
    case "REWARD"=>getRewardPrice(map.values.toList)
  }

  def getRegularPrice(list:List[Int])=list(0)*wdRegular+list(1)*weRegular
  def getRewardPrice(list: List[Int]) =list(0)*wdReward+list(1)*weReward
}

val Lakewood=new Hotel("Lakewood",3,110,80,90,80)
val Ridgewood=new Hotel("Ridgewood",4,160,110,60,50)
val Bridgewood=new Hotel("Bridgewood",5,220,100,150,40)
val hotelList:List[Hotel]=List(Lakewood,Ridgewood,Bridgewood)
//
//val getPriceList=hotelList.map(hotel=>hotel->hotel.getPrice("REWARD",Map(0->2,1->2)))
//println(getPriceList)
//val min=getPriceList.minBy(_._2)._2
//val cheapestHotels=getPriceList.filter(_._2==min)
//val highestrated=cheapestHotels.maxBy(_._1.rating)._1.name
//1+
2
2
+1
//def getWeekpart(date:LocalDate)=date.getDayOfWeek.getValue match {
//  case 1|2|3|4|5 => 0
//  case 6|7 => 1
//  case _ => -1
//
//}
val dates=List(LocalDate.of(2019,2,23),LocalDate.of(2019,2,24))
val dayCount=dates.map(date=>getWeekpart(date))
  .groupBy(identity)
  .mapValues(x=>x.size)


val getPriceList=hotelList.map(hotel=>hotel->hotel.getPrice("REWARD",Map(1->2)))
println(getPriceList)
val getPriceMap=hotelList.map(hotel => hotel->hotel.getPrice("REGULAR",dayCount))

println(getPriceMap)

val list=List(1,1,2,2,3)
list.groupBy(x=>x)
