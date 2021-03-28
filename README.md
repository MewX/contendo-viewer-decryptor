This repo is used to support analysing the worst platform I've ever used - Contendo.

To update file list:

```shell
$ find -name "*.java" > sources.txt
```

To compile everything:

```shell
$ javac @sources.txt
```

To run the Main class:

```shell
$ java Main
```

----

To decrypt a directory (unpacked epub) or single file:

1. you would need to find the decryption key from `info` file using Main class.

2. update the Decrypt key in `Decrypt.java` and run:

    ```shell
    $ java Decrypt <source_dir> <destionation_dir>
    ```
