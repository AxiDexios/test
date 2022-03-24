package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class test {

	public static void main(String[] args) {
		
		int days = 2;  //кол-во суток
		int sleep = 8;  //время для сна в сутки
		
		Map<Integer, Double> places = new HashMap<Integer, Double>();  //список достопримечательностей в виде (важность, время)
			places.put(10, 5.0);
			places.put(11, 8.0);
			places.put(4, 3.5);
			places.put(7, 10.0);
			places.put(15, 9.0);
			places.put(17, 1.0);
			places.put(3, 4.0);
			places.put(9, 2.0);
			places.put(12, 7.0);
			places.put(6, 5.5);
			places.put(19, 2.0);
			places.put(8, 5.0);
			places.put(20, 12.0);
			places.put(13, 2.0);
			places.put(2, 4.0);
			places.put(5, 1.5);
			places.put(14, 1.0);
			places.put(18, 3.0);
			places.put(1, 6.0);
			places.put(16, 7.0);
		
		double wake = 24 - sleep;	
		
		Map<Integer, Double> eff = new HashMap<Integer, Double>();	
		for (int i = 1; i <= places.size(); i++){
			eff.put(i, places.get(i) * i);	
		}
		
		double time = 0;
		double lost_time = 0;
		double hours = 0;
		int day = 1;
		Entry<Integer, Double> min = null;
		
		while (day <= days){
			
			if (places.size() == 0) 
				break;
			
			for (Entry<Integer, Double> entry : eff.entrySet()) {
			    if (min == null || min.getValue() > entry.getValue()) {
			        min = entry;
			    }
			}

				if (places.get(min.getKey()) < wake - time) {
					
					time = time + places.get(min.getKey());
					hours = hours + places.get(min.getKey());
					System.out.println("Достопримечательность №" + min.getKey());
					System.out.println("Затрачено времени - " + places.get(min.getKey()) + " ч");
					System.out.println("Всего затрачено времени " + hours + " ч");
					System.out.println(" ");
					eff.remove(min.getKey());
					places.remove(min.getKey());
					min = null;
					continue;
				}
				
				for (Entry<Integer, Double> entry : places.entrySet()) {
				    if (min == null || min.getValue() > entry.getValue()) {
				        min = entry;
				    }
				}
				if (places.get(min.getKey()) < wake - time) {
					
					time = time + places.get(min.getKey());
					hours = hours + places.get(min.getKey());
					System.out.println("Достопримечательность №" + min.getKey());
					System.out.println("Затрачено времени - " + places.get(min.getKey()) + " ч");
					System.out.println("Всего затрачено времени " + hours + " ч");
					System.out.println(" ");
					eff.remove(min.getKey());
					places.remove(min.getKey());
					min = null;
					continue;
				}
				
				System.out.println("Перерыв на сон!!!");
				hours = hours + 8;
				day = day + 1;
				lost_time = wake - time;
				wake = wake + lost_time;
				System.out.println("Неиспользованное время дня - " + lost_time + " ч");
				System.out.println("Всего затрачено времени " + hours + " ч");
				System.out.println(" ");
				time = 0;
		}	
	}	
}
