Feature: Account Registration via Email

  Scenario: Mandatory field validation for empty fields
    Given the user is on the home page
    When the user selects "es" as the language
    And the user clicks "Start Playing"
    And the user clicks the Accept button in the terms modal
    And the user selects "Jugar con Email"
    When the user clicks on the "CREAR CUENTA" button
    Then the user should see the message "El email es obligatorio" for the email field
    And the user should see the message "La contraseña es obligatoria" for the password field

  Scenario Outline: Email format validation
    Given the user is on the home page
    When the user selects "es" as the language
    And the user clicks "Start Playing"
    And the user clicks the Accept button in the terms modal
    And the user selects "Jugar con Email"
    And the user enters an invalid email "<invalid_email>"
    Then an error message "Formato de email incorrecto" should be displayed

    Examples:
      | invalid_email |
      | user@         |
      | user.com      |

  Scenario: Password length validation
    Given the user is on the home page
    When the user selects "es" as the language
    And the user clicks "Start Playing"
    And the user clicks the Accept button in the terms modal
    And the user selects "Jugar con Email"
    And the user enters a password "123" in the Password field
    Then an error length password message "Debe contener 6 caracteres como mínimo" should be displayed

  Scenario: Password Mismatch Validation
    Given the user is on the home page
    When the user selects "es" as the language
    And the user clicks "Start Playing"
    And the user clicks the Accept button in the terms modal
    And the user selects "Jugar con Email"
    And the user enters a password "1234567" in the Password field
    And the user enters a password "1234567" in the Confirm Password field
    Then an error mismatch password message "Las contraseñas no coinciden" should be displayed