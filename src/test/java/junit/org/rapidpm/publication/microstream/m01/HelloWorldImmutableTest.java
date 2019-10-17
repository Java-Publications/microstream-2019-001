package junit.org.rapidpm.publication.microstream.m01;

import one.microstream.storage.types.EmbeddedStorage;
import one.microstream.storage.types.EmbeddedStorageManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rapidpm.publication.microstream.m01.HelloWorldImmutable;

public class HelloWorldImmutableTest {

  @Test
  void test001() {
    final HelloWorldImmutable value = new HelloWorldImmutable("HelloWorldImmutable");
    final EmbeddedStorageManager storageManager = EmbeddedStorage.start();
    storageManager.setRoot(value);
    storageManager.storeRoot();
    storageManager.shutdown();
  }

  @Test
  void test002() {
    final EmbeddedStorageManager storageManager = EmbeddedStorage.start();
    final Object                 root           = storageManager.root();
    Assertions.assertTrue(root instanceof HelloWorldImmutable);
    HelloWorldImmutable helloWorld = (HelloWorldImmutable) root;
    Assertions.assertEquals("HelloWorldImmutable", helloWorld.getValue());
    storageManager.shutdown();
  }
}
