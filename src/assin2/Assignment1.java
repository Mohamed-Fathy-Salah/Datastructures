package assin2;
public class Assignment1 {
   public static void main(String[] args) {
      LinkedList l = new LinkedList();

      l.pushFront("mhmd", r1(), r());
      l.pushFront("fthy", r1(), r());
      l.pushFront("salah", r1(), r());
      l.pushFront("tawfik", r1(), r());
      l.pushFront("azab", r1(), r());
      l.pushFront("ahmed", r1(), r());
      l.pushFront("soal", r1(), r());
      l.pushFront("cool", r1(), r());
      l.pushFront("soap", r1(), r());
      l.pushFront("shal", r1(), r());

      System.out.println("whole list");
      l.print();

      LinkedList passed = l.getPassed();

      System.out.println("passed students");
      passed.print();

      System.out.println("failed students");
      l.print();
   }

   // get random value from [20 , 23]
   private static int r1() {
      return 20 + (int) (Math.random() * 3);
   }

   // get random value from [10 , 100]
   private static int r() {
      return 10 + (int) (Math.random() * 90);
   }
}

class Link {
   public String name;
   public int age, degree;
   public Link next;

   public Link(String name, int age, int degree) {
      this.name = name;
      this.age = age;
      this.degree = degree;
   }

   public boolean passed() {
      return degree >= 50;
   }

   @Override
   public String toString() {
      return "name :" + name + "\t,age :" + age + "\t,degree :" + degree;
   }
}

class LinkedList {

   private Link first;

   public void pushFront(String name, int age, int degree) {
      Link student = new Link(name, age, degree);
      student.next = first;
      first = student;
   }

   // get the passed students
   public LinkedList getPassed() {
      Link cur = first, prev = first;
      LinkedList ret = new LinkedList();
      while (cur != null) {
         if (cur.passed()) {
            // delete node
            if (cur == first)
               first = first.next;
            else
               prev.next = cur.next;
            // PushFront in the new list
            ret.pushFront(cur.name, cur.age, cur.degree);
         } else
            prev = cur;
         cur = cur.next;
      }
      return ret;
   }

   public void print() {
      Link cur = first;
      while (cur != null) {
         System.out.println(cur);
         cur = cur.next;
      }
      System.out.println();
   }
}
/* sample output
whole list
name :shal      ,age :20        ,degree :88
name :soap      ,age :20        ,degree :74
name :cool      ,age :22        ,degree :84
name :soal      ,age :22        ,degree :52
name :ahmed     ,age :22        ,degree :96
name :azab      ,age :20        ,degree :86
name :tawfik    ,age :22        ,degree :52
name :salah     ,age :21        ,degree :44
name :fthy      ,age :21        ,degree :14
name :mhmd      ,age :22        ,degree :14

passed students
name :tawfik    ,age :22        ,degree :52
name :azab      ,age :20        ,degree :86
name :ahmed     ,age :22        ,degree :96
name :soal      ,age :22        ,degree :52
name :cool      ,age :22        ,degree :84
name :soap      ,age :20        ,degree :74
name :shal      ,age :20        ,degree :88

failed students
name :salah     ,age :21        ,degree :44
name :fthy      ,age :21        ,degree :14
name :mhmd      ,age :22        ,degree :14
*/