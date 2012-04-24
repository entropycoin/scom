/**
 * Sample1.java
 * Test of ScomItem: add connections and retrieve them
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
package scom.samples;

import scom.ScomItem;

public class Sample1 
{
  public static void main(String[] args) 
  {
    System.out.println("**** Sample 1: add connections and retrieve them ****");
    
    ScomItem item1          = ScomItem.GetScomItem("name", "item1");
    
    ScomItem klass          = ScomItem.GetScomItem("name", "Item");
    ScomItem klass_relation = ScomItem.GetScomItem("name", "class");
    
    ScomItem metaklass      = ScomItem.GetScomItem("name", "Class");
    item1.connect(klass_relation, klass);
    klass.connect(klass_relation, metaklass);
    
    System.out.println("evaluate on 'item1': " + item1.evaluate());
    
    ScomItem query_result;
    query_result = item1.getItem("name", "class");
    System.out.println("query(name,class) on 'item1': " + query_result.evaluate());
    
    query_result = query_result.getItem("name", "class");
    System.out.println("query(name,class) on 'class': " + query_result.evaluate());
    
    System.out.println("query(***,$$$) on 'item1': " + item1.getItem("***", "$$$"));
  } //---- main()
} //---- Sample1 class
