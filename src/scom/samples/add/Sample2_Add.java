/**
 * Sample2_Add.java
 * Test of the Additioner Item: ScomItemAdd (subclass of ScomItem)
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
package scom.samples.add;

import java.util.ArrayList;
import scom.ScomItem;

public class Sample2_Add 
{
  public static void main(String[] args) 
  {
    System.out.println("**** Sample 2: Add ****");
    
    ArrayList<ScomItem> add_params = new ArrayList<ScomItem>();
      add_params.add(ScomItem.GetScomItem("value", "0.33"));
      add_params.add(ScomItem.GetScomItem("value", "0.66"));
    
    ScomItem add_item = ScomItemAdd.GetScomItem("name", "add");
    System.out.println(add_item.evaluate(add_params));
  } //---- main()
} //---- Sample2_Add class
