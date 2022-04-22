# Assert, Annotations Workshop

1. Feladat

Írjátok át a JUnit teszteket AssertJ tesztekre. (A megadott projectben a MyStack generikus stack implementáció van tesztelve.)

2. Feladat

Implementáljatok egy saját Spring-et. Az ezt megvalósító fájlok legyenek saját package-ben (simplespring).
Hozzatok létre 2 annotációt
 - `Configuration` - ezzel tudjátok jelezni, hogy az osztályotok configuráció.
 - `Bean` - ezzel tudjátok jelezni, hogy a configurációs osztályban levő metódus egy bean lesz.
 
Az `ApplicationContext` osztályotok konstruktorának paramétere várja majd a konfigurációs osztályotokat.
(Ha nem konfigurációs osztály példányt kap, dobjon kivételt)
Ez alapján hozza létre öngában a bean-eket.

 - Legyen egy `Object getBean(Class clazz)` metódusa, amivel típus alapján lehet elkérni a bean-eket.

Main kód:

```java
	public class Annotations {

		public static void main(String[] args) {
			ApplicationContext context = new ApplicationContext(new MyConfig());
			MyObject o = (MyObject) context.getBean(MyObject.class);
			System.out.println(o.foo());
			String stringBean = (String) context.getBean(String.class);
			System.out.println(stringBean);
		}
	}

	class MyObject {
		public String foo() {
			return "I'm " + this.getClass().getName() + "!";
		}
	}
```
