_greenForLoops_ is a SonarQube plugin created to detect and rectify energy code-smells in different loop types in Java. The motivation behind this plugin is twofold. Firstly, it aims to help developers uncover energy-related issues and assess their impact on resource consumption, and apply appropriate optimizations or refactoring strategies. By this, it will lower energy consumption and carbon footprints. Secondly, optimizing energy efficiency in software has tangible benefits. Businesses can reduce their operational costs by installing energy-efficient applications.

This plugin is created as an artifact for a thesis for an Erasmus Mundus joint's Master's Degree called [SE4GD](https://se4gd.lutsoftware.com),which aims to educate Software Engineers with a sustainability mindset.

To build this plugin, [ecoCode](https://github.com/green-code-initiative/ecoCode) and [sonar-java](https://github.com/SonarSource/sonar-java/blob/master/docs/CUSTOM_RULES_101.md) custom rule's doocumentation were used as the main references.

**Alert**: This plugin is in an early phase of development. There can be many more that can be added or improved. Any suggestions are welcome.


How to install the plugin?
--------------------------

The plugin can be installed from two ways:
- You can try by using the following docker command:
  ```sh
  docker run -p 9000:9000 \
      --name sonar-green-for-loops ghcr.io/ramgrg/sonar-green-for-loops:latest
  ```
- You can download jar file from the Release section and copy the jar file to `$SONAR_INSTALL_DIR/extensions/plugins` before starting SonarQube.

After SonarQube started to run in a browser, please create Quality Profile by adding rules with `green-code` tag. All the rules are of type, `Code Smell`.


How SonarQube plugin works?
--------------------------
To perform static code analysis by SonarQube, a set of rules should be defined. As per those rules, a plugin is developed that will analyses the source code, a very similar way antivirus softwares detect viruses. In addition, if the source code violates these rules, SonarQube labels those codes with issue.
While analysing the source code, SonarQube parses the source code by building an abstract syntax tree(AST). For more information, please go through this [link](https://docs.sonarqube.org/latest/extension-guide/adding-coding-rules/).

Provide feedback after testing the plugin
--------------------------
After you finish testing your projects or any open source proojects, please feel free to fill up the feedback form:
https://forms.gle/rZCgTrvCPAsEtnoU6
