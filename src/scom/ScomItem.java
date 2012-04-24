/**
 * ScomItem.java
 * Core and Single class of SCOM project
 * ...................................................................................
 * SCOM: Single Class Object Model
 * http://code.google.com/p/scom/
 * Licence: MIT (http://en.wikipedia.org/wiki/MIT_License)
 * Michel Kern - 23 april 2012 - www.terimakasi.com
 * Copyright (C) <year> <copyright holders>
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
package scom;

import java.util.ArrayList;
import java.util.HashMap;

public class ScomItem implements java.util.Map.Entry<Object, Object> 
{
  public static ScomItem                NIL = new ScomItem("NIL", "NIL");
    
  protected HashMap<ScomItem, ScomItem> _connections = new HashMap<ScomItem, ScomItem>();
  protected HashMap<String, ScomItem>   _kv2item     = new HashMap<String, ScomItem>();
  protected final             Object    _key;
  protected                   Object    _value;
  
  //**** Caution !! this static 'pseudo constructor' must be overloaded in each subclass **** 
  static public ScomItem GetScomItem(Object key, Object value) 
  {
    if (isNIL(key,value))  return NIL;
    return new ScomItem(key, value);
  } // Public Pseudo Constructor
  //**** Caution !! this static 'pseudo constructor' must be overloaded in each subclass **** 
  
  static protected boolean isNIL(Object key, Object value)
  {
    return (key.toString().toUpperCase() == "NIL" && value.toString().toUpperCase() == "NIL");
  } //---- isNIL()
  
  protected ScomItem(Object key, Object value) 
  {
    _key   = key;
    _value = value;
  } // Private Constructor
  
  private static String keyValue(Object key, Object value)
  { 
    return "[" + key.toString() + "," + value.toString() + "]";
  } //---- KeyValuePair
  
  public void connect(ScomItem relation, ScomItem target)
  {  
    _connections.put(relation, target);
    _kv2item.put(keyValue(relation._key, relation._value), relation);
    _kv2item.put(keyValue(target._key, target._value), target);
  } //---- connectWith()  
  
  public ScomItem evaluate()
  {   
    return evaluate(null);
  } //---- evaluate() 
    
  public ScomItem evaluate(ArrayList<ScomItem> input)
  {   
    return this;
  } //---- evaluate() 
  
  public ScomItem getItem(Object key, Object value)
  {  
    String kv_key = keyValue(key, value);
    
    if (_kv2item.containsKey(kv_key))
    {
      //return _kv2item.get(kv_key);
      return getItem(_kv2item.get(kv_key));
    }
    return NIL;
  } //---- getItem(K, V)
  
  public ScomItem getItem(ScomItem key)
  {   
    if (_connections.containsKey(key))
    {
      ScomItem key_item = _connections.get(key);
      return key_item;
    }
    return null;
  } //---- getItem()
  
  public HashMap<ScomItem, ScomItem> getConnections()
  {   
    return _connections;
  } //---- getConnections()
  
  @Override
  public String toString()   { return _value.toString(); }

  @Override
  public Object getKey()   { return _key; }

  @Override
  public Object getValue() { return _value; }

  @Override
  public Object setValue(Object new_value) 
  {
    Object old  = _value;
    _value = new_value;
    return old;
  } //---- setValue()
} //---- ScomItem class