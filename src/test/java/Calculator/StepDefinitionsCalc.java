package Calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.*;

import org.junit.Assert;

public class StepDefinitionsCalc {

	Calculator calculator;
	Integer result;
@Given("I have a calculator")
public void i_have_a_calculator() {
    calculator = new Calculator();
}

@When("I add {int} and {int}")
public void i_add_and(Integer intA, Integer intB) {
    result = calculator.add(intA, intB);
}

@Then("I should get {int}")
public void i_should_get(Integer intExpectedResult) {
 Assert.assertEquals(intExpectedResult, result);
	
}
	

}
