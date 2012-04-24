/**
 * Sample3_Add_Multiply.java
 * Test of the Additioner and Multiplier Items: ScomItemAdd and ScomItemMultiply
 * ...................................................................................
 * SCOM: Single Class Object Model
 * http://code.google.com/p/scom/
 * Licence: MIT
 * Michel Kern - 23 april 2012 - www.terimakasi.com
 * ...................................................................................
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal 
 * in the Software without restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of 
 * the Software, and to permit persons to whom the Software is furnished to do so, 
 * subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all 
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS 
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF
 * OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * ...................................................................................
 */
package scom.samples.add_multiply;

import java.util.ArrayList;
import scom.ScomItem;
import scom.samples.add.ScomItemAdd;

public class Sample3_Add_Multiply 
{
  public static void main(String[] args) 
  {
    System.out.println("**** Sample 3: Add and Multiply ****");
    
    ScomItem add_item      = ScomItemAdd.GetScomItem("name", "add");
    ScomItem multiply_item = ScomItemMultiply.GetScomItem("name", "multiply");
    
    ArrayList<ScomItem> add_params = new ArrayList<ScomItem>();
      add_params.add(ScomItem.GetScomItem("value", "1.5"));
      add_params.add(ScomItem.GetScomItem("value", "3.5"));
      
    ArrayList<ScomItem> multiply_params = new ArrayList<ScomItem>();
      multiply_params.add(ScomItem.GetScomItem("value", "2"));
      multiply_params.add(ScomItem.GetScomItem("value", "3")); 
      multiply_params.add(add_item.evaluate(add_params));
      
    ScomItem multiply_result = multiply_item.evaluate(multiply_params);
    System.out.println("(1.5 + 3.5) * 2 * 3 = " + multiply_result);
  } //---- main()
} //---- Sample3_Add_Multiply class