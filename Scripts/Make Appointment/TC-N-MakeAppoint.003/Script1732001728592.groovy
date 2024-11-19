import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')
WebUI.maximizeWindow()
WebUI.click(findTestObject('Object Repository/Login Repository/Page_Login/a_CURA Healthcare_menu-toggle'))
WebUI.click(findTestObject('Object Repository/Login Repository/Page_Login/a_Login'))
WebUI.setText(findTestObject('Object Repository/Login Repository/Page_Login/input_Username_username'), '')
WebUI.setText(findTestObject('Object Repository/Login Repository/Page_Login/input_Password_password'), '')
WebUI.click(findTestObject('Object Repository/Login Repository/Page_Login/button_Login'))
boolean isElementPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Make Appointment Repository/Page_Make Appointment/input_Visit Date (Required)_visit_date'))

if (isElementPresent) {
	println('Visit date is present')
} else {
	println('Visit date is not present')
}
WebUI.click(findTestObject('Object Repository/Make Appointment Repository/Page_Make Appointment/button_Book Appointment'))
boolean isValueEntered = WebUI.verifyTextPresent('Visit Date is Required', false, FailureHandling.STOP_ON_FAILURE)
if (isValueEntered) {
	println('Book Failed')
} else {
	println('Book Success')
}

WebUI.closeBrowser()