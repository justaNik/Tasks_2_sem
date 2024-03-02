package task_2;

public class logic {

/*
    public static int fib(int n) {
         final int[] fibCashe = new int[1000];
        MyLinkedList<Integer> list = new MyLinkedList<>();
        int result = 1;
        if (n < 0) {
            System.out.println("Are you stupid? imposible get value fib for non-positive number");
        }
        if (n <= 2) {
            list.addLast(result);
            return result;
        }
        if (n < fibCashe.length && fibCashe[n] > 0) {
            return fibCashe[n];
        }
        result = fib(n - 1) + fib(n - 2);
        fibCashe[n] = result;
        list.addLast(result);

        return result;
    }

 */

    public static MyLinkedList<Integer> fib1(int n) throws Exception{
        MyLinkedList<Integer> list = new MyLinkedList<>();
        int res = 0, prev = 0, nextNum = 1;
        if (n <= 0){
            throw new Exception("Incorrect value");
        }

        for (int i = 1; i <= n; i++){
            if (i == 1){
                list.addLast(prev);
                continue;
            }
            if (i == 2){
                list.addLast(1);
                continue;
            }
            res = prev + nextNum;
            list.addLast(res);
            prev = nextNum;
            nextNum = res;
        }
        return list;
        }

        public static  StringBuilder listToString(MyLinkedList<Integer> list){
        int i = 0;
       StringBuilder str = new StringBuilder();
            for (Integer v : list) {
                v.toString();
                str.append(v).append(" ");
                i++;
            }
            return str;
        }
    }

