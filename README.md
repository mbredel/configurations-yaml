# Configurations-YAML
A YAML extension to Apache Commons Configuration 1.x

The Commons Configuration software library (https://commons.apache.org/proper/commons-configuration/index.html) provides a generic configuration interface which enables a Java application to read configuration data from a variety of sources. Commons Configuration provides typed access to single, and multi-valued configuration parameters. By default it allows for configuration parameters loaded from sources, like Properties files, XML documents, and Windows INI files. 

The YAML extension allows loading configuration from YAML files like

```YAML
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
```


To load, verify, and write YAML files configuration-yaml leverages the SnakeYAML (http://www.snakeyaml.org/) YAML parser and emitter.

## License
This software is licensed under the Apache 2 license, quoted below.

Copyright (C) 2016 Michael Bredel. (http://www.bredel.at).

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
