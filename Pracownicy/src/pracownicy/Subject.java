/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracownicy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maciek
 */
public class Subject {
       private List<Observer> observers = new ArrayList<Observer>();
    private Worker worker;
    
    public Subject(){
        
    }
    public void setProduct(Worker worker){
        this.worker = worker;
    }
    
    public Worker getModel(){
        return worker;
    }
    public void clear(boolean a, boolean b){
        notifyAllObservers();
    }
    public void add(){
        notifyAllObservers();
    }
    public void attach(Observer observer){
      observers.add(observer);		
   }
    public void notifyAllObservers(){
        
      for (Observer observer : observers) {
         observer.update();
      }
    }
}
