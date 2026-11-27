import java.util.*;
/** Typed Observer-pattern exercise (plain Java, no deprecated java.util.Observable). */
public class WeatherStation {
 public record Reading(double celsius,double humidity,double pressure){}
 @FunctionalInterface public interface Observer { void update(Reading reading); }
 private final List<Observer> observers=new ArrayList<>(); private Reading current=new Reading(0,0,0);
 public void subscribe(Observer observer){observers.add(Objects.requireNonNull(observer));}
 public void unsubscribe(Observer observer){observers.remove(observer);}
 public void setReading(double c,double h,double p){current=new Reading(c,h,p);for(Observer o:List.copyOf(observers))o.update(current);}
 public static void main(String[] args){WeatherStation station=new WeatherStation();station.subscribe(r->System.out.printf("Current %.1f°C, humidity %.0f%%%n",r.celsius(),r.humidity()));station.subscribe(r->System.out.printf("Pressure trend sample: %.1f hPa%n",r.pressure()));station.setReading(22.5,61,1013.2);}
}
