Feature: Simple Tests

  Scenario: Insert text into texfield
  As a user When I add hello luca I should see hello luca

    When I launch UIKitCatalog app
    Then I tap on Alert Views
    Then I tap on Text Entry
    And I choose to enter "Hello Luca"
    Then I should see "Hello Luca"

  Scenario: Change Date
    As a user When I change Date I should see Date Below

    Given I am in MainPage
    And I tap on DatePicker cell
    And I tap on DatePicke element
    And I tap on "martedì 26 luglio"
    Then I tap out the datePicker
    Then i should see 30

    @search
    Scenario: Change value Picker View
      As a user I can change PickerView values

      Given I am in MainPage1
      And I tap PickerView
      And I change RGB colous in 5 55 170
      Then Value are 5 55 170

