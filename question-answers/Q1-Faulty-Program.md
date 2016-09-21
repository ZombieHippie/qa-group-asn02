## Q1: 5 points

There is a faulty program/code snippet in the following textbox.

```java
public int countPositive (int[] x)
{
//Effects: If x==null throw NullPointerException
//  else return the number of
//    positive elements in x.
  int count = 0;
  for (int i=0; i < x.length; i++)
  {
    if (x[i] >= 0)
    {
      count++;
    }
  }
  return count;
}
  // test:  x=[-4, 2, 0, 2]
  //        Expected = 2
```

Answer the following questions: (1 point each)
a) Identify the fault.
b) Identify a test case that does NOT execute the fault.
c) Identify a test case that executes the fault, but does not result in an error state.
d) Identify a test case that results in an error, but not a failure. (Hint: Error results in failure if not handled by the program)
e) For the given test case in the textbox, identify the first error state during runtime. Describe the complete state including the values of each of the variables, expected and actual results.
