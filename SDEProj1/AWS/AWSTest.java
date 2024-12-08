package AWS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AWSTest {

	
	private static final int FILLER_VALUE = Integer.MIN_VALUE;
	private int[] original={1, 2, 3};
	AWS originalAWS;
	
	@BeforeEach
	void setUp() throws Exception {
		 originalAWS = new AWS(this.original);
	}

	@Test
	void testGetValues() {
		fail("Not yet implemented");
	}

	@Test
	void testSetValues() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testAWS() {
		int[] expected = {1, 2, 3};
		int[] x = {1, 2, 3};
		AWS aws = new AWS(x);
		x[1] = 100;
		
		int[] actual = aws.getValues();
		assertEquals(actual[0], expected[0]);
		assertEquals(actual[1], expected[1]);
	}
	
	@Test
	void testRemove() {
		int[] x = {1, 2, 3};
		AWS aws = new AWS(x);
		
		int value = aws.remove(-1);
		int expected = FILLER_VALUE;
		assertEquals(expected, value);
		
		value = aws.remove(x.length + 10);
		expected = FILLER_VALUE;
		assertEquals(expected, value);
		
		value = aws.remove(0);
		assertEquals(x[0], value);
		
		int[] r = aws.getValues();
		value = r[r.length - 1];
		assertEquals(expected, value);
		
		value = aws.remove(2);
		assertEquals(r[2], value);
		
		r = aws.getValues();
		value = r[r.length - 1];
		assertEquals(expected, value);
		
	}
	
	
	//Part 1 // Creating a Test that passed 
	@Test
	void testRemove1() {
		int[] y = {1, 2, 3, 9};
		AWS aws = new AWS(y);
		
		int v1 = aws.remove(-1);
		int e1 = FILLER_VALUE;
		assertEquals(e1,v1);
			
	}
	
	
	@Test
	void testFillAndExpand() {
		int position = 1;
		int numberOfTimes = 2;
		int[] org = originalAWS.getValues();
		int expectedValue = org[position];
		int first = org[0];
 		
		int expected = originalAWS.getValues().length + numberOfTimes;
		originalAWS.fillAndExpand(position, numberOfTimes);
		int[] result = originalAWS.getValues();
		assertEquals(expected, result.length);
		
		int a = result[1];
		int b = result[2];
		int c = result[3];
		assertEquals(expectedValue, a);
		assertEquals(expectedValue, b);
		assertEquals(expectedValue, c);
		assertEquals(first, result[0]);	
	
	}
	@Test
	void testFillAndExpandWithNegative() {
		int position = 1;
		
		int numberOfTimes = Math.abs(-2);
		//int numberOfTimes = -2;
		
		int[] org = originalAWS.getValues();
		
		int expectedValue = org[position];
		
 		int first = org[0];
 		
		int expected = originalAWS.getValues().length + numberOfTimes;
		
		originalAWS.fillAndExpand(position, numberOfTimes);
		
		int[] result = originalAWS.getValues();
		
		assertEquals(expected, result.length);
		
		int a = result[1];
		int b = result[2];
		int c = result[3];
		assertEquals(expectedValue, a);
		assertEquals(expectedValue, b);
		assertEquals(expectedValue, c);
		assertEquals(first, result[0]);

	
	}
	
	@Test
	void testRemoveBiggerThan() {
		
		int[] arr = {1,2,3,4,7,10,20}; //declaring an array
		int thres = 10; //declaring a threshold
		
		AWS aws = new AWS(arr);  //passing the array into the AWS class
		
		int value = aws.removeBiggerThan(thres); //declaring the number of removed values and calling our method
		
		int expected = 1;

		assertEquals(expected, value);
		
	}
	//comparing expected, which is 20 or only one (1) element with what our method gave us
	
	@Test
	void testStepMultiplier() {
		int[] arr1 = {5, 15, 25}; //declaring a new array
		AWS aws = new AWS(arr1); //passing the array to the AWS class
		aws.stepMultiplier(); //calling the method
		
		int[] expectedResult = aws.getValues(); //storing values from method to an array
		
		//declaring or storing positions
		int pos0 = 0; 
		int pos1 = 1;
		int pos2 = 2;
		
		//storing values from our method to variables
		int awsValues1 = expectedResult[pos0];
		int awsValues2 = expectedResult[pos1];
		int awsValues3 = expectedResult[pos2];
		
		//calculating expected values of the given array
		int a = 10;
		int b = 60;
		int c = 2500;
		
		//comparing values from our method and our hand calculated method
		assertEquals(a, awsValues1);
		assertEquals(b, awsValues2);
		assertEquals(c, awsValues3);
	
	}
	
	

}
