package utility

import java.time.LocalDate

object ConverterUtility {

    def getWeekpart(date:LocalDate)=date.getDayOfWeek.getValue match {
      case 1|2|3|4|5 => 0
      case 6|7 => 1
      case _ => -1

    }
}
