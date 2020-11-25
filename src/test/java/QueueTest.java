import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

@Test(expected = IllegalArgumentException.class)
public void maxQuelengthTest(){
    new Queue(0);
}


@Test
public void enqueueTest(){
    Queue queue = new Queue(2);
    queue.enqueue(1);
    Assert.assertEquals(1,queue.queue[0]);
}

@Test
public void enqueueFullQueueTest(){
    Queue queue = new Queue(3);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    //Queue ist voll. Neue Zahl wird hinzugefügt.
    queue.enqueue(5);
    queue.enqueue(6);
    //Neue Zahl sollte an letzer stelle der Queue stehen
    Assert.assertEquals(6, queue.queue[2]);
}

@Test
public void dequeueTest(){
    Queue queue = new Queue(3);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    Assert.assertEquals(1, queue.dequeue());
}

@Test(expected = IllegalStateException.class)
public void dequeEmptyQueueTest(){
    Queue queue = new Queue(1);
    queue.dequeue();
}

@Test
public void ringSpeicherTest(){
    Queue queue = new Queue(3);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.dequeue();
    queue.dequeue();
    Assert.assertEquals(2, queue.head);
    Assert.assertEquals(2,queue.tail);
}



}
