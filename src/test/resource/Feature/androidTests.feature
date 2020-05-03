Feature: Select date in Andoid Apps

  @androiddatePicker
  Scenario Outline:Select date
    Given User selects the <date>
#    Then  User check for the <date>
  Examples:
  |date          |
  |23/03/2020    |
  |24/04/2020    |
  |26/04/2020    |
  |28/06/2020    |
  |28/07/2020    |

#  Date format in DD/MM/YYYY
#Then User sees the selected date
#  //23/24/26/28/29


