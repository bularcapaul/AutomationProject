Feature: Calendar Test

  Scenario Outline: User creates a calendar event
    Given User is logged in with email "<email>", password "<password>", and phone number "<phoneNumber>"
    When User navigates to the specific day "<date>"
    And User creates a new event "<eventText>"
    Then The event "<eventText>" is present in the calendar
    Examples:
      | email                | password | phoneNumber | date       | eventText          |
      | testuser10@gmail.com | pass123  | 2234567899  | 2024-07-21 | Training with John |
      | testuser11@gmail.com | pass123  | 3234567817  | 2024-07-22 | Training with Mark |
      | testuser12@gmail.com | pass123  | 4234567817  | 2024-07-23 | Training with Mark |
      | testuser13@gmail.com | pass123  | 5234567817  | 2024-07-24 | Training with Mark |
      | testuser14@gmail.com | pass123  | 6234567817  | 2024-07-25 | Training with Mark |

