package pl.kodujmy

import spock.lang.*

class BloodTypesSpec extends Specification {

  private BloodTypes bloodTypes = new BloodTypes()

  
  def "Should return #survive for #bloodType and #donatedBlood"() {
    expect:
    bloodTypes.survive(bloodType, donatedBlood) == survive

    where:
    bloodType | donatedBlood                       || survive
    "A+"      | ["A+"]                             || true
    "A+"      | ["B+"]                             || false
    "A-"      | ["B+", "AB+", "A+"]                || false
    "A-"      | ["B+", "AB+", "A-"]                || true
    "A-"      | ["0-"]                             || true
    "A+"      | ["B-", "B+", "AB-", "AB+"]         || false
    "A+"      | ["B-", "B+", "AB-", "AB+", "0-"]   || true
  }


  def "Should convert #symbol to right enum #bloodType"() {
    expect:
    BloodType.fromSymbol(symbol) == bloodType

    where:
    symbol || bloodType
    "A+"   || BloodType.A_PLUS
    "AB+"  || BloodType.AB_PLUS
    "AB-"  || BloodType.AB_MINUS
    "0-"   || BloodType.ZERO_MINUS
  }

}
