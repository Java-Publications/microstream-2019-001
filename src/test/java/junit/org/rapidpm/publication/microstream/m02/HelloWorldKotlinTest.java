package junit.org.rapidpm.publication.microstream.m02;

import one.microstream.storage.types.EmbeddedStorage;
import one.microstream.storage.types.EmbeddedStorageManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rapidpm.dependencies.core.logger.HasLogger;
import org.rapidpm.publication.microstream.m01.HelloWorld;
import org.rapidpm.publication.microstream.m02.HelloWorldImmutableKotlin;
import org.rapidpm.publication.microstream.m02.HelloWorldKotlin;
import org.rapidpm.publication.microstream.m02.HelloWorldKotlinDataclass;

public class HelloWorldKotlinTest
    implements HasLogger {

  @Test
  void test001() {
    final HelloWorldKotlin value = new HelloWorldKotlin();
    value.setValue("HelloWorldKotlin");
    final EmbeddedStorageManager storageManager = EmbeddedStorage.start();
    storageManager.setRoot(value);
    storageManager.storeRoot();
    storageManager.shutdown();
  }

  @Test
  void test002() {
    final EmbeddedStorageManager storageManager = EmbeddedStorage.start();
    final Object                 root           = storageManager.root();
    Assertions.assertTrue(root instanceof HelloWorldKotlin);
    HelloWorldKotlin helloWorld = (HelloWorldKotlin) root;
    Assertions.assertEquals("HelloWorldKotlin", helloWorld.getValue());
    storageManager.shutdown();
  }

  @Test
  void test011() {
    final HelloWorldImmutableKotlin value = new HelloWorldImmutableKotlin("HelloWorldImmutableKotlin");
    final EmbeddedStorageManager storageManager = EmbeddedStorage.start();
    storageManager.setRoot(value);
    storageManager.storeRoot();
    storageManager.shutdown();
  }

  @Test
  void test012() {
    final EmbeddedStorageManager storageManager = EmbeddedStorage.start();
    final Object                 root           = storageManager.root();
    Assertions.assertTrue(root instanceof HelloWorldImmutableKotlin);
    HelloWorldImmutableKotlin helloWorld = (HelloWorldImmutableKotlin) root;
    Assertions.assertEquals("HelloWorldImmutableKotlin", helloWorld.getValue());
    storageManager.shutdown();
  }

  @Test
  void test021() {
    final HelloWorldKotlinDataclass value          = new HelloWorldKotlinDataclass("HelloWorldKotlinDataclass");
    final EmbeddedStorageManager    storageManager = EmbeddedStorage.start();
    storageManager.setRoot(value);
    storageManager.storeRoot();
    storageManager.shutdown();
  }

  @Test
  void test022() {
    final EmbeddedStorageManager storageManager = EmbeddedStorage.start();
    final Object                 root           = storageManager.root();
    Assertions.assertTrue(root instanceof HelloWorldKotlinDataclass);
    HelloWorldKotlinDataclass helloWorld = (HelloWorldKotlinDataclass) root;
    Assertions.assertEquals("HelloWorldKotlinDataclass", helloWorld.getValue());
    storageManager.shutdown();
  }
}
