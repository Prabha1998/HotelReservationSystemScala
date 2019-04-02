package database

import model.Hotel

object HotelDatabase extends App{
  def Lakewood=new Hotel("Lakewood",3,110,80,90,80)
  def Ridgewood=new Hotel("Bridgewood",4,160,110,60,50)
  def Bridgewood=new Hotel("Ridgewood",5,220,100,150,40)
  def hotelList:List[Hotel]=List(Lakewood,Ridgewood,Bridgewood)
  println(hotelList)
}
