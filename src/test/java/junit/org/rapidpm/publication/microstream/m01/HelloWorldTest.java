package junit.org.rapidpm.publication.microstream.m01;

import one.microstream.storage.types.EmbeddedStorage;
import one.microstream.storage.types.EmbeddedStorageManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rapidpm.dependencies.core.logger.HasLogger;
import org.rapidpm.publication.microstream.m01.HelloWorld;

public class HelloWorldTest
    implements HasLogger {

  @Test
  void test001() {
    final HelloWorld value = new HelloWorld();
    value.setValue("HelloWorld");
    final EmbeddedStorageManager storageManager = EmbeddedStorage.start();
    storageManager.setRoot(value);
    storageManager.storeRoot();
    storageManager.shutdown();
  }

  @Test
  void test002() {
    final EmbeddedStorageManager storageManager = EmbeddedStorage.start();
    final Object                 root           = storageManager.root();
    Assertions.assertTrue(root instanceof HelloWorld);
    HelloWorld helloWorld = (HelloWorld) root;
    Assertions.assertEquals("HelloWorld", helloWorld.getValue());
    storageManager.shutdown();
  }
}
