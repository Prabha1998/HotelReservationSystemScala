package model

class Hotel(var name:String,var rating:Int,var wdRegular:Int,var wdReward:Int,var weRegular:Int,var weReward:Int){

  def getPrice(customerType:String,map: Map[Int,Int])=customerType match{
  case "REGULAR"=>getRegularPrice(replace(map.get(0)),replace(map.get(1)))
  case "REWARD"=>getRewardPrice(replace(map.get(0)),replace(map.get(1)))
 }

  def replace(i: Option[Int])=if(i==None)0 else i.get

  def getRegularPrice(wd:Int,we:Int)=wd*wdRegular+we*weRegular

  def getRewardPrice(wd:Int,we:Int)=wd*wdReward+we*weReward

}
