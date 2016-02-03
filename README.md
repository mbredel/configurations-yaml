# configurations-yaml
A YAML extension to Apache Commons Configuration

The Commons Configuration software library (https://commons.apache.org/proper/commons-configuration/index.html) provides a generic configuration interface which enables a Java application to read configuration data from a variety of sources. Commons Configuration provides typed access to single, and multi-valued configuration parameters. By default it allows for configuration parameters loaded from sources, like Properties files, XML documents, and Windows INI files. 

The YAML extension allows loading configuration from YAML files like

  ---
  key1: value1

  key2:
    key3: value2

  key4:
    key5:
      - col1
      - col2  

  text: >
    This is text that
    spans multiple lines


To load, verify, and write YAML files configuration-yaml leverages the SnakeYAML (http://www.snakeyaml.org/) YAML parser and emitter.
