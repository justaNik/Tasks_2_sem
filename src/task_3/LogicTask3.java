package task_3;

public class LogicTask3 {
    public  static SimpleQueue<String> logic(String str){
        SimpleQueue<String> queue = new QueueTwoStacks<>();
        String[] arrStr = str.split(" ");
        for (String string : arrStr) {
            queue.add(string);
        }
        return queue;
    }

    public static  String outQueueToString(SimpleQueue<String> que) throws Exception {
        StringBuilder strb = new StringBuilder();
        while (que.size() > 0){
            String val = que.remove();
            strb.append(val).append(" ");
        }
        return strb.toString();
    }
}
