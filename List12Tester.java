/**
 * Assignment 1             List12Tester.java         Due. April 12
 * login: cs12sni
 **/

//import junit.framework package and java.util package
import junit.framework.*;
import java.util.*;

/**
 * Class List12Test is a subclass of TestCase from junit.framework
 * This class is a tester for List12.class, a subclass of LinkedList
 * Eight methods will be tested in this tester
 * @author Ruiqing Qiu
 * @version 1.0 April. 6 2013
 *
 * @see org.junit.Assert
 * @see junit.framework.TestCase
 * @see java.util.Iterator <E>
 * @see java.util.List <E>
 * @see junit.framework.TestCase
 * @see java.util.LinkedList
 **/
public class List12Tester extends TestCase
{
  //a final integer used to in number of loops to set up integer list 
  public final int NUM_CYCLE_TEST = 1000;

 /**
  * This method is testing the add() and contains() methods of the
  * java.util.List <E> interface. 
  * Specifically, Testing to make sure
  * contains() works for on a list with multiple elements and it can identify
  * when elements are bot present and not present in the list.
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/ 
  public void testAddContains()
  {
    List<String> theL = new List12<String>();
    theL.add("A");
    theL.add("B");
    assertTrue(theL.contains("A"));
    assertTrue(theL.contains("B"));
    assertFalse(theL.contains("C"));
  }
 
 /**
  * This method is testing the add() and get() methods of the 
  * java.util.List<E> interface.
  * Testing to make sure get() works for a integer list and match 
  * the expected value
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/  
  public void testAddGet()
  {
    //setup the integer list
    List<Integer> theL = new List12<Integer>();
    
    //for loop to add the integers to the list
    for(int i = 1; i <= NUM_CYCLE_TEST; i++)
    {
      theL.add(i);
    }
    
    //for loop to check if the the integer match the expected value
    for(int i = 0; i < NUM_CYCLE_TEST; i++)
    {
      assertEquals(theL.get(i),new Integer(i+1));
    }
  }

 /**
  * This method is testing add method's return value of the 
  * java.util.List<E> interface.
  * Testing to make sure every element that is added return true
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/  
  public void testAddReturn()
  {
    //set up a String list
    List<String> theL = new List12<String>();
    //test the return value
    assertTrue(theL.add("A"));
    assertTrue(theL.add("B"));
    assertTrue(theL.add("A"));
  }
  
 /**
  * This method is tesing add method's correct functionality 
  * using get(), size() and add() 
  * of the java.util.List<E>
  * Testing if the element is added to the end of the list
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/ 
  public void testAddAtEnd()
  {
    //set up a String list
    List<String> theL = new List12<String>();
    
    //check the element is added to the end of the list
    theL.add("A");
    assertEquals("A",theL.get(theL.size()-1));
    theL.add("B");
    assertEquals("B", theL.get(theL.size()-1));
    theL.add("C");
    assertEquals("C", theL.get(theL.size()-1));
  }
  
 /**
  * This method is testing for the method add(int index, E element)
  * of the java.util.List <E> interface.
  * Testing to make sure all the elements are added to the list
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/ 
  public void testAddIndexContains()
  { 
    //set up a integer list
    List<Integer> theL = new List12<Integer>();
    //a for loop to set up a list of 1000 even numbers
    for(int i = 0, num = 0; i < NUM_CYCLE_TEST; i++, num+=2)
    {
      theL.add(i,num);
    }
    for(int i = 0; i < 2*NUM_CYCLE_TEST; i+=2)
    {
      assertTrue(theL.contains(i));
    }
  }
 
 /**
  * This method is testing for the method add(int index, E element)
  * using get() of the java.util.List<E> interface.
  * Testing to make sure element is added in correct position and value
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/  
  public void testAddIndexGet()
  {
    //set up an integer list
    List<Integer> theL = new List12<Integer>();
    //a for loop to put even integers into the list
    for(int i = 0, num = 0; i <=1000; i++, num+=2)
    {
      theL.add(i,num);
    }
    //a for loop to see if the expected value in each index match 
    for(int i=0, j = 0; i<=1000;i++,j+=2)
    {
      assertEquals(theL.get(i), new Integer(j));
    }  
  }
  
 /**
  * This method is testing the method add(int index, E element)
  * check if index out of range will correctly throw exception
  * IndexOutOfBoundsException thrown by LinkedList
  * @see java.util.LinkedList <E>
  * @see java.util.List <E>
  **/  
  public void testAddIndexOutOfException()
  {
    //set up an integer list with 1000 integers
    List<Integer> theL = new List12<Integer>();
    for(int i = 0; i < NUM_CYCLE_TEST; i++)
    {
      theL.add(i);
    }
    //exception check for index as negative
    try
    {
      theL.add(-1, 10);
      fail();
    }
    catch(IndexOutOfBoundsException e)
    {
    }
    //exception check for index larger than size()
    try
    {
      theL.add(theL.size()+1,10);
    }
    catch(IndexOutOfBoundsException e)
    {}
  }
  
 /**
  * This method is testing for the method contains(Object o)
  * using add() of java.util.List<E>
  * Testing correct return value when elements is added
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/ 
  public void testContainsAdd()
  {
    //set up a list of integers
    List<Integer> theL = new List12<Integer>();
    for(int i = 0; i <=NUM_CYCLE_TEST;i++)
    {
      theL.add(i);
    }
    for(int i = 0; i <=NUM_CYCLE_TEST;i++)
    {
      assertTrue(theL.contains(i));
    }
    //check that it will return false when numbers are not in the list
    for(int i = NUM_CYCLE_TEST +1; i < 2*NUM_CYCLE_TEST; i++)
    {
      assertTrue(!theL.contains(i));
    }
  }
 
 /**
  * This method is testing for the method contains(Object o)
  * using remove() of java.util.List<E>
  * Testing correct return value when elements is removed
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/ 
  public void testContainsRemove()
  {
    //set up a String list
    List<String> theL = new List12<String>();
    
    //add three elements into the list
    theL.add("A");
    theL.add("B");
    theL.add("C");
    //remove one of the element
    theL.remove("A");
    //check if false will be returned
    assertFalse(theL.contains("A"));
  }
  
 /**
  * This method is testing for the method public E get(int index)
  * using add of java.util.List<E>
  * testing the correct get return value when elements are added
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/
  public void testGetAdd()
  {
    //set up an integer list
    List<Integer> theL = new List12<Integer>();
    for(int i = 1; i <= 1000; i++)
    {
      theL.add(i);
    }
    //check that get will return the same value as expected
    for(int i = 0; i < 1000; i++)
    {
      assertEquals(new Integer(i+1), theL.get(i));
    }
  }
  
 /**
  * This method is testing for the method public E get(int index)
  * See if IndexOutOfBoundsException will be thrown when
  * index is negative or larger than or equal to size()
  * @see java.util.List <E>
  **/ 
  public void testGetOutOfBoundException()
  {
    List<Integer> theL = new List12<Integer>();
    for(int i = 0; i <= NUM_CYCLE_TEST; i++)
    {
      theL.add(i);
    }
    try
    {
      theL.remove(-1);
      fail();
    }
    catch(IndexOutOfBoundsException e)
    {}
    try
    {
      theL.remove(theL.size());
      fail();
    }
    catch(IndexOutOfBoundsException e)
    {}
    try
    {
      theL.remove(theL.size()+1);
      fail();
    }
    catch(IndexOutOfBoundsException e)
    {}
  } 
  
 /**
  * This method is testing for the method public boolean remove(Object o)
  * using add() and contains() of the java.util.List<E>
  * Check if the only value in the list removed and contains will return
  * false
  * @see java.util.List <E>  
  * @see org.junit.Assert 
  **/ 
  public void testRemoveReturn()
  {
     //set up a list of three String elements
     List<String> theL = new List12<String>();
     theL.add("A");
     theL.add("B");
     theL.add("C");
     
     //remove "B" element
     theL.remove("B");
     //check if the correct false value is returned
     assertFalse(theL.contains("B"));
  }
 
 /**
  * This method is testing for the method remove(Object o)
  * Check if the first occurrence of the Object o will be removed but not 
  * second one using add() and get() of the java.util.List<E>
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/
  public void testRemoveFirstOccurrence()
  {
    //set up a list of four String elements with two duplicate
    List<String> theL = new List12<String>();
    theL.add("A");
    theL.add("B");
    theL.add("C");
    theL.add("A");
    
    //remove the duplicate element
    theL.remove("A");
    //check if the other one still exist
    assertTrue(theL.contains("A"));
    //check that the first element of the list is "B"
    assertEquals("B",theL.get(0));
    //check that the third element of the list is "A"
    assertEquals("A",theL.get(2));
  } 
 
 /**
  * This method is testing the method remove(Object o)
  * Testing the correct change in size() when element is removed
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/
  public void testRemoveSize()
  { 
    //set up a list of four String elements
    List<String> theL = new List12<String>();
    theL.add("A");
    theL.add("B");
    theL.add("C");
    theL.add("D");
    
    //remove the element and check if the size change correctly
    theL.remove("A");
    assertEquals(3,theL.size());
    theL.remove("B");
    assertEquals(2,theL.size());
  }

 /**
  * This method is testing the return value of remove(Object o) 
  * method of java.util.List<E>
  * Testing the correct return value when element is removed
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/  
  public void testRemoveBooleanReturn()
  {
    //set up a list of three String elements
    List<String> theL = new List12<String>();
    theL.add("A");
    theL.add("B");
    theL.add("C");
    
    //check if the correct return value
    assertTrue(theL.remove("A"));
    assertFalse(theL.remove("D"));
  }

 /**
  * This method is testing the E remove(int index) method
  * using size() of the java.util.List<E>
  * Testing the size change correctly when element of
  * a particular index is removed
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/
  public void testRemoveIndexSize()
  {
    //set up a list of integers
    List<Integer> theL = new List12<Integer>();
    for(int i = 1; i <= NUM_CYCLE_TEST; i++)
    {
      theL.add(i);
    }
    //remove the first and second index
    theL.remove(1);
    assertEquals(NUM_CYCLE_TEST-1,theL.size());
    theL.remove(2);
    assertEquals(NUM_CYCLE_TEST-2,theL.size());
  }
 
 /**
  * This method is testing for the method public E remove(int index)
  * Check if the return value is the element that is removed
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/
  public void testRemoveElementReturn()
  {
    //set up a list of three String elements
    List<String> theL = new List12<String>();
    theL.add("A");
    theL.add("B");
    theL.add("C");
    
    //check if the return value of removed element is correct
    assertEquals("A", theL.remove(0));
  }
   
 /**
  * This method is testing the method E remove(int index)
  * Check if the IndexOutOfBoundsException will be thrown correctly 
  * when index is negative or larger than or equal to size() of 
  * java.util.List <E>
  * @see java.util.List <E>
  **/ 
  public void testRemoveIndexOutOfBoundsException()
  {
    //set up a list of integers
    List<Integer> theL = new List12<Integer>();
    for(int i = 0; i <= NUM_CYCLE_TEST; i++)
    {
      theL.add(i);
    }
    //remove an element that is out of range
    try
    {
      theL.remove(theL.size()+1);
      fail();
    }
    catch(IndexOutOfBoundsException e)
    {
    }
    try
    {
      theL.remove(theL.size());
    }
    catch(IndexOutOfBoundsException e)
    {}
    try
    {
      theL.remove(-1);
    }
    catch(IndexOutOfBoundsException e)
    {}
  }

 /**
  * This method is testing for the method public E set(int index, E element)
  * using add() contains() of java.util.List<E>
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/
  public void testSetReturn()
  {
    //set up a list of Strings
    List<String> theL = new List12<String>();
    theL.add("A");
    theL.add("B");
    theL.add("C");
    
    //check it will return the old element at the position
    assertEquals("B",theL.set(1,"D"));
    //check that the element is set correctly
    assertTrue(theL.contains("D"));
    //check the position of the element is correct
    assertEquals("D",theL.get(1));
  }
 
 /**
  * This method is testing for the method public E set(int index, E element)
  * check if the IndexOutBoundsException will be thrown correctly
  * @see java.util.List <E>
  **/ 
  public void testSetIndexOutOfBoundsException()
  {
    //set up a list of integers
    List<Integer> theL = new List12<Integer>();
    for(int i = 0; i <= NUM_CYCLE_TEST;i++)
    {
      theL.add(i);
    }
    try
    {
      theL.set(-1,1);
      fail();
    }
    catch(IndexOutOfBoundsException e)
    {}
    try
    {
      theL.set(theL.size(),1);
      fail();
    }
    catch(IndexOutOfBoundsException e)
    {}
    try
    { 
      theL.set(theL.size()+1, 1);
      fail();
    }
    catch(IndexOutOfBoundsException e)
    {}
  }
  
 /**
  * This method is testing for public int size();
  * using add() of java.util.List<E>
  * @see java.util.List <E>
  * @see org.junit.Assert 
  **/
  public void testSizeAdd()
  {
    //set up a list of integers
    List<Integer> theL = new List12<Integer>();
    for(int i = 1; i <=NUM_CYCLE_TEST; i++)
    {
      theL.add(i);
    }
    //check the size is correct when element is added
    assertEquals(NUM_CYCLE_TEST,theL.size());
    theL.add(1001);
    assertEquals(NUM_CYCLE_TEST+1,theL.size());
  }
   
 /**
  * This method is testing for iterator method hasNext()
  * using iterator() of java.lang.Iterable <T>
  * @see java.util.Iterator <E>
  * @see java.util.List <E>
  * @see java.lang.Iterable <T>
  * @see org.junit.Assert 
  **/ 
  public void testIteratorHasNext()
  {
    //set up a String list 
    List<String> theL = new List12<String>();
    //check if the false will return correctly
    assertFalse(theL.iterator().hasNext());
    
    //add two String elements to the list
    theL.add("A");
    theL.add("B");
    //check if the true value will return correctly   
    assertTrue(theL.iterator().hasNext());
  }
  
 /**
  * This method is testing for iterator method next()
  * using iterator() of java.lang.Iterable <T>
  * @see java.util.Iterator <E>
  * @see java.util.List <E>
  * @see java.lang.Iterable <T>
  * @see org.junit.Assert 
  **/   
  public void testIteratorNext()
  {
    //set up a String of two elements
    List<String> theL = new List12<String>();
    theL.add("A");
    theL.add("B");
    
    //check the correct return value 
    assertEquals("A", theL.iterator().next());
  }
  
 /**
  * This method is testing for iterator method next()
  * check if NoSuchElementException is thrown correctly
  * @see java.util.Iterator <E>
  * @see java.util.List <E>
  * @see java.lang.Iterable <T>
  **/ 
  public void testIteratorNextNoSuchElementException()
  {
    //set up an empty String list
    List<String> theL = new List12<String>(); 
    //check if NoSuchElementException is thrown correctly
    try
    {
      theL.iterator().next();
      fail();
    }
    catch(NoSuchElementException e)
    {}
  }
 
 /**
  * This method is testing for iterator method remove()
  * using hasNext() and next() of java.util.Iterator
  * @see java.util.Iterator <E>
  * @see java.util.List <E>
  * @see java.lang.Iterable <T>
  * @see org.junit.Assert 
  **/ 
  public void testIteratorRemove()
  {
    //set up a String list containing one element
    List<String> theL = new List12<String>();
    theL.add("A");
    
    //set up an iterator
    Iterator itr = theL.iterator();
    //call the next() and remove()
    itr.next();
    itr.remove();
    //check there's no next in the iterator
    assertFalse(itr.hasNext());
  }

 /**
  * This method is testing for iterator method remove()
  * Check IllegalStateException is thrown correctly
  * @see java.lang.IllegalStateException
  * @see java.lang.Iterable <T>
  * @see java.util.List <E>
  * @see java.util.Iterator <E>
  **/   
  public void testIteratorRemoveIllegalStateException()
  {
    //set up an empty list
    List<String> theL = new List12<String>();
    //set up an iterator 
    Iterator itr = theL.iterator();
    try
    {
      //call remove without next()
      itr.remove();
    }
    catch(IllegalStateException e)
    {}
  }
 
 /**
  * Main method of the class, will run the junit test and show the result
  * @see junit.textui.TestRunner
  * @see junit.swingui.TestRunner
  * @see junit.framework.TestCase
  **/ 
  public static void main(String[]args)
  {
    junit.textui.TestRunner.main(new String[] {"List12Tester"});
  }
}
