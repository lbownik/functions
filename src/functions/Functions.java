//
//Copyright (C) 2018 Łukasz Bownik
//
//Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
//associated documentation files (the "Software"), to deal in the Software without restriction, including 
//without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
//copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the 
//following conditions:
//
//The above copyright notice and this permission notice shall be included in all copies or substantial 
//portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
//LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
//IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
//HETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
//SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
package functions;

/*******************************************************************************
 *
 ******************************************************************************/
public class Functions {

   /****************************************************************************
    *
    ***************************************************************************/
   public interface F0<R> {

      /*************************************************************************
       *
       ************************************************************************/
      R call() throws Exception;
      /*************************************************************************
       *
       ************************************************************************/
      default <R1> F0<R1> andThen(final F1<R1, R> f) {

         return () -> f.callWith(this.call());
      }
      /**************************************************************************
       *
       *************************************************************************/
      default P0 asP() throws Exception {

         return () -> this.call();
      }
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public static <R> F0<R> f(final F0<R> func) {

      return func;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static <R> F0<R> f0ThatReturns(final R o) {

      return () -> o;
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public interface F1<R, T1> {

      /*************************************************************************
       *
       ************************************************************************/
      R callWith(T1 o1) throws Exception;

      /*************************************************************************
       *
       ************************************************************************/
      default F0<R> bind1(final T1 o1) {

         return () -> this.callWith(o1);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default <R1> F1<R1, T1> andThen(final F1<R1, R> f) {

         return (o1) -> f.callWith(this.callWith(o1));
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P1<T1> asP() throws Exception {

         return (o1) -> this.callWith(o1);
      }
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public static <R, T1> F1<R, T1> f(final F1<R, T1> func) {

      return func;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static <R, T1> F1<R, T1> f1ThatReturns(final R o) {

      return (o1) -> o;
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public interface F2<R, T1, T2> {

      /**************************************************************************
       *
       *************************************************************************/
      R callWith(T1 o1, T2 o2) throws Exception;

      /**************************************************************************
       *
       *************************************************************************/
      default F1<R, T2> bind1(final T1 o1) {

         return (o2) -> this.callWith(o1, o2);
      }

      /*************************************************************************
       *
       ************************************************************************/
      default F1<R, T1> bind2(final T2 o2) {

         return (o1) -> this.callWith(o1, o2);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default <R1> F2<R1, T1, T2> andThen(final F1<R1, R> f) {

         return (o1, o2) -> f.callWith(this.callWith(o1, o2));
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P2<T1, T2> asP() throws Exception {

         return (o1, o2) -> this.callWith(o1, o2);
      }
   }

   /****************************************************************************
    *
    ****************************************************************************/
   public static <R, T1, T2> F2<R, T1, T2> f(final F2<R, T1, T2> func) {

      return func;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static <R, T1, T2> F2<R, T1, T2> f2ThatReturns(final R o) {

      return (o1, o2) -> o;
   }

   /****************************************************************************
    *
    ****************************************************************************/
   public interface F3<R, T1, T2, T3> {

      /*************************************************************************
       *
       ************************************************************************/
      R callWith(T1 o1, T2 o2, T3 o3) throws Exception;

      /*************************************************************************
       *
       ************************************************************************/
      default F2<R, T2, T3> bind1(final T1 o1) {

         return (o2, o3) -> this.callWith(o1, o2, o3);
      }

      /*************************************************************************
       *
       ************************************************************************/
      default F2<R, T1, T3> bind2(final T2 o2) {

         return (o1, o3) -> this.callWith(o1, o2, o3);
      }

      /*************************************************************************
       *
       ************************************************************************/
      default F2<R, T1, T2> bind3(final T3 o3) {

         return (o1, o2) -> this.callWith(o1, o2, o3);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default <R1> F3<R1, T1, T2, T3> andThen(final F1<R1, R> f) {

         return (o1, o2, o3) -> f.callWith(this.callWith(o1, o2, o3));
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P3<T1, T2, T3> asP() throws Exception {

         return (o1, o2, o3) -> this.callWith(o1, o2, o3);
      }
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public static <R, T1, T2, T3> F3<R, T1, T2, T3> f(final F3<R, T1, T2, T3> func) {

      return func;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static <R, T1, T2, T3> F3<R, T1, T2, T3> f3ThatReturns(final R o) {

      return (o1, o2, o3) -> o;
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public interface F4<R, T1, T2, T3, T4> {

      /*************************************************************************
       *
       ************************************************************************/
      R callWith(T1 o1, T2 o2, T3 o3, T4 o4) throws Exception;

      /*************************************************************************
       *
       ************************************************************************/
      default F3<R, T2, T3, T4> bind1(final T1 o1) {

         return (o2, o3, o4) -> this.callWith(o1, o2, o3, o4);
      }

      /*************************************************************************
       *
       ************************************************************************/
      default F3<R, T1, T3, T4> bind2(final T2 o2) {

         return (o1, o3, o4) -> this.callWith(o1, o2, o3, o4);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default F3<R, T1, T2, T4> bind3(final T3 o3) {

         return (o1, o2, o4) -> this.callWith(o1, o2, o3, o4);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default F3<R, T1, T2, T3> bind4(final T4 o4) {

         return (o1, o2, o3) -> this.callWith(o1, o2, o3, o4);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default <R1> F4<R1, T1, T2, T3, T4> andThen(final F1<R1, R> f) {

         return (o1, o2, o3, o4) -> f.callWith(this.callWith(o1, o2, o3, o4));
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P4<T1, T2, T3, T4> asP() throws Exception {

         return (o1, o2, o3, o4) -> this.callWith(o1, o2, o3, o4);
      }
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public static <R, T1, T2, T3, T4> F4<R, T1, T2, T3, T4> f(final F4<R, T1, T2, T3, T4> func) {

      return func;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static <R, T1, T2, T3, T4> F4<R, T1, T2, T3, T4> f4ThatReturns(final R o) {

      return (o1, o2, o3, o4) -> o;
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public interface F5<R, T1, T2, T3, T4, T5> {

      /*************************************************************************
       *
       ************************************************************************/
      R callWith(T1 o1, T2 o2, T3 o3, T4 o4, T5 o5) throws Exception;

      /*************************************************************************
       *
       ************************************************************************/
      default F4<R, T2, T3, T4, T5> bind1(final T1 o1) {

         return (o2, o3, o4, o5) -> this.callWith(o1, o2, o3, o4, o5);
      }

      /*************************************************************************
       *
       ************************************************************************/
      default F4<R, T1, T3, T4, T5> bind2(final T2 o2) {

         return (o1, o3, o4, o5) -> this.callWith(o1, o2, o3, o4, o5);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default F4<R, T1, T2, T4, T5> bind3(final T3 o3) {

         return (o1, o2, o4, o5) -> this.callWith(o1, o2, o3, o4, o5);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default F4<R, T1, T2, T3, T5> bind4(final T4 o4) {

         return (o1, o2, o3, o5) -> this.callWith(o1, o2, o3, o4, o5);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default F4<R, T1, T2, T3, T4> bind5(final T5 o5) {

         return (o1, o2, o3, o4) -> this.callWith(o1, o2, o3, o4, o5);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default <R1> F5<R1, T1, T2, T3, T4, T5> andThen(final F1<R1, R> f) {

         return (o1, o2, o3, o4, o5) -> f.callWith(this.callWith(o1, o2, o3, o4, o5));
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P5<T1, T2, T3, T4, T5> asP() throws Exception {

         return (o1, o2, o3, o4, o5) -> this.callWith(o1, o2, o3, o4, o5);
      }
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static <R, T1, T2, T3, T4, T5> F5<R, T1, T2, T3, T4, T5> f(final F5<R, T1, T2, T3, T4, T5> func) {

      return func;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static <R, T1, T2, T3, T4, T5> F5<R, T1, T2, T3, T4, T5> f5ThatReturns(final R o) {

      return (o1, o2, o3, o4, o5) -> o;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public interface F6<R, T1, T2, T3, T4, T5, T6> {

      /*************************************************************************
       *
       ************************************************************************/
      R callWith(T1 o1, T2 o2, T3 o3, T4 o4, T5 o5, T6 o6) throws Exception;

      /*************************************************************************
       *
       ************************************************************************/
      default F5<R, T2, T3, T4, T5, T6> bind1(final T1 o1) {

         return (o2, o3, o4, o5, o6) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }

      /*************************************************************************
       *
       ************************************************************************/
      default F5<R, T1, T3, T4, T5, T6> bind2(final T2 o2) {

         return (o1, o3, o4, o5, o6) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default F5<R, T1, T2, T4, T5, T6> bind3(final T3 o3) {

         return (o1, o2, o4, o5, o6) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default F5<R, T1, T2, T3, T5, T6> bind4(final T4 o4) {

         return (o1, o2, o3, o5, o6) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default F5<R, T1, T2, T3, T4, T6> bind5(final T5 o5) {

         return (o1, o2, o3, o4, o6) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default F5<R, T1, T2, T3, T4, T5> bind6(final T6 o6) {

         return (o1, o2, o3, o4, o5) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default <R1> F6<R1, T1, T2, T3, T4, T5, T6> andThen(final F1<R1, R> f) {

         return (o1, o2, o3, o4, o5, o6) -> f.callWith(this.callWith(o1, o2, o3, o4, o5, o6));
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P6<T1, T2, T3, T4, T5, T6> asP() throws Exception {

         return (o1, o2, o3, o4, o5, o6) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static <R, T1, T2, T3, T4, T5, T6> F6<R, T1, T2, T3, T4, T5, T6> f(final F6<R, T1, T2, T3, T4, T5, T6> func) {

      return func;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static <R, T1, T2, T3, T4, T5, T6> F6<R, T1, T2, T3, T4, T5, T6> f6ThatReturns(final R o) {

      return (o1, o2, o3, o4, o5, o6) -> o;
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public interface P0 {

      /*************************************************************************
       *
       ************************************************************************/
      void call() throws Exception;
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public static P0 p(final P0 proc) {

      return proc;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static P0 p0ThatDoesNothing() {

      return () -> {
      };
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public interface P1<T1> {

      /*************************************************************************
       *
       ************************************************************************/
      void callWith(T1 o1) throws Exception;

      /*************************************************************************
       *
       ************************************************************************/
      default P0 bind1(final T1 o1) {

         return () -> this.callWith(o1);
      }
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public static <T1> P1<T1> p(final P1<T1> proc) {

      return proc;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static P1 p1ThatDoesNothing() {

      return (o1) -> {
      };
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public interface P2<T1, T2> {

      /*************************************************************************
       *
       ************************************************************************/
      void callWith(T1 o1, T2 o2) throws Exception;

      /*************************************************************************
       *
       ************************************************************************/
      default P1<T2> bind1(final T1 o1) {

         return (o2) -> this.callWith(o1, o2);
      }

      /*************************************************************************
       *
       ************************************************************************/
      default P1<T1> bind2(final T2 o2) {

         return (o1) -> this.callWith(o1, o2);
      }
   }

   /****************************************************************************
    *
    ****************************************************************************/
   public static <T1, T2> P2<T1, T2> p(final P2<T1, T2> proc) {

      return proc;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static P2 p2ThatDoesNothing() {

      return (o1, o2) -> {
      };
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public interface P3<T1, T2, T3> {

      /*************************************************************************
       *
       ************************************************************************/
      void callWith(T1 o1, T2 o2, T3 o3) throws Exception;

      /*************************************************************************
       *
       ************************************************************************/
      default P2<T2, T3> bind1(final T1 o1) {

         return (o2, o3) -> this.callWith(o1, o2, o3);
      }

      /*************************************************************************
       *
       ************************************************************************/
      default P2<T1, T3> bind2(final T2 o2) {

         return (o1, o3) -> this.callWith(o1, o2, o3);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P2<T1, T2> bind3(final T3 o3) {

         return (o1, o2) -> this.callWith(o1, o2, o3);
      }
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public static <T1, T2, T3> P3<T1, T2, T3> p(final P3<T1, T2, T3> proc) {

      return proc;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static P3 p3ThatDoesNothing() {

      return (o1, o2, o3) -> {
      };
   }

   /*****************************************************************************
    *
    ***************************************************************************/
   public interface P4<T1, T2, T3, T4> {

      /*************************************************************************
       *
       ************************************************************************/
      void callWith(T1 o1, T2 o2, T3 o3, T4 o4) throws Exception;

      /*************************************************************************
       *
       ************************************************************************/
      default P3<T2, T3, T4> bind1(final T1 o1) {

         return (o2, o3, o4) -> this.callWith(o1, o2, o3, o4);
      }

      /*************************************************************************
       *
       ************************************************************************/
      default P3<T1, T3, T4> bind2(final T2 o2) {

         return (o1, o3, o4) -> this.callWith(o1, o2, o3, o4);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P3<T1, T2, T4> bind3(final T3 o3) {

         return (o1, o2, o4) -> this.callWith(o1, o2, o3, o4);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P3<T1, T2, T3> bind4(final T4 o4) {

         return (o1, o2, o3) -> this.callWith(o1, o2, o3, o4);
      }
   }

   /*****************************************************************************
    *
    ***************************************************************************/
   public static <T1, T2, T3, T4> P4<T1, T2, T3, T4> p(final P4<T1, T2, T3, T4> proc) {

      return proc;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static P4 p4ThatDoesNothing() {

      return (o1, o2, o3, o4) -> {
      };
   }

   /****************************************************************************
    *
    ***************************************************************************/
   public interface P5<T1, T2, T3, T4, T5> {

      /*************************************************************************
       *
       ************************************************************************/
      void callWith(T1 o1, T2 o2, T3 o3, T4 o4, T5 o5) throws Exception;

      /*************************************************************************
       *
       ************************************************************************/
      default P4<T2, T3, T4, T5> bind1(final T1 o1) {

         return (o2, o3, o4, o5) -> this.callWith(o1, o2, o3, o4, o5);
      }

      /*************************************************************************
       *
       ************************************************************************/
      default P4<T1, T3, T4, T5> bind2(final T2 o2) {

         return (o1, o3, o4, o5) -> this.callWith(o1, o2, o3, o4, o5);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P4<T1, T2, T4, T5> bind3(final T3 o3) {

         return (o1, o2, o4, o5) -> this.callWith(o1, o2, o3, o4, o5);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P4<T1, T2, T3, T5> bind4(final T4 o4) {

         return (o1, o2, o3, o5) -> this.callWith(o1, o2, o3, o4, o5);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P4<T1, T2, T3, T4> bind5(final T5 o5) {

         return (o1, o2, o3, o4) -> this.callWith(o1, o2, o3, o4, o5);
      }
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static <T1, T2, T3, T4, T5> P5<T1, T2, T3, T4, T5> p(final P5<T1, T2, T3, T4, T5> proc) {

      return proc;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static P5 p5ThatDoesNothing() {

      return (o1, o2, o3, o4, o5) -> {
      };
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public interface P6<T1, T2, T3, T4, T5, T6> {

      /*************************************************************************
       *
       ************************************************************************/
      void callWith(T1 o1, T2 o2, T3 o3, T4 o4, T5 o5, T6 o6) throws Exception;

      /*************************************************************************
       *
       ************************************************************************/
      default P5<T2, T3, T4, T5, T6> bind1(final T1 o1) {

         return (o2, o3, o4, o5, o6) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }

      /*************************************************************************
       *
       ************************************************************************/
      default P5<T1, T3, T4, T5, T6> bind2(final T2 o2) {

         return (o1, o3, o4, o5, o6) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P5<T1, T2, T4, T5, T6> bind3(final T3 o3) {

         return (o1, o2, o4, o5, o6) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P5<T1, T2, T3, T5, T6> bind4(final T4 o4) {

         return (o1, o2, o3, o5, o6) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P5<T1, T2, T3, T4, T6> bind5(final T5 o5) {

         return (o1, o2, o3, o4, o6) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }
      /*************************************************************************
       *
       ************************************************************************/
      default P5<T1, T2, T3, T4, T5> bind6(final T6 o6) {

         return (o1, o2, o3, o4, o5) -> this.callWith(o1, o2, o3, o4, o5, o6);
      }
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static <T1, T2, T3, T4, T5, T6> P6<T1, T2, T3, T4, T5, T6> p(final P6<T1, T2, T3, T4, T5, T6> proc) {

      return proc;
   }
   /****************************************************************************
    *
    ***************************************************************************/
   public static P6 p6ThatDoesNothing() {

      return (o1, o2, o3, o4, o5, o6) -> {
      };
   }
}
