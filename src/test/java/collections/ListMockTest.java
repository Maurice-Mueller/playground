package collections;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public final class ListMockTest {

  @Test
  public void addTest() {
    List<String> mockedList = mock(List.class);
    mockedList.add("hello");
    assertEquals(0, mockedList.size());
    verify(mockedList).add("hello");
  }

  @Test
  public void testStubSize() {
    List<String> mockedList = mock(List.class);
    when(mockedList.size()).thenReturn(10);
    assertEquals(10, mockedList.size());
  }
}
