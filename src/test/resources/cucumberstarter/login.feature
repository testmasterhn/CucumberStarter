#Author: khanh.tx@live.com

Feature: Testmaster Login Function

  Scenario: Show error message on tooltip for invalid username and invalid password
  Given I am staying testmaster login page
  When I provide invalid value for username and password
  Then I should see the corresponding message on tooltip
  
  
  
  Scenario: Show popup message to indicate pasword not right for wrong password input
  Given I am staying testmaster login page
  When I provide valid value for username and wrong password
  Then I should see the popup message "Tên đăng nhập hoặc Mật khẩu không đúng." in bold format and "Chú ý: Mật khẩu có độ dài >6 ký tự và chỉ chứa chữa hoa, chữ thường và số" in Italic format 
    